package gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.function.Consumer;

import application.Main;
import db.DB;
import gui.util.Alerts;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;
import model.services.DepartmentService;
import model.services.SellerService;

public class MainViewController implements Initializable {

    @FXML
    private MenuItem menuItemSeller;
    @FXML
    private MenuItem menuItemDepartment;
    @FXML
    private MenuItem meniItemAbout;

    @FXML
    public void onMenuItemSellerAction() {
    	try {
            DB.getConnection();          
            System.out.println("✅ Conexão com o banco de dados realizada com sucesso!");
        } 
        catch (Exception e) {
            System.out.println("❌ Erro ao conectar com o banco de dados:");
            e.printStackTrace();
            Alerts.showAlert("Erro de Conexão", 
                    "Não foi possível conectar ao banco de dados", 
                    e.getMessage(), 
                    AlertType.ERROR);
            return;  
        }

        loadView("/gui/SellerList.fxml", (SellerListController controller) -> {
            controller.setSellerSevice(new SellerService());
            controller.updateTableView();
        });
    }

    @FXML
    public void onMenuItemDepartmentAction() {
        // ==================== TESTE DE CONEXÃO ====================
        try {
            DB.getConnection();           // Força a conexão com o banco
            System.out.println("✅ Conexão com o banco de dados realizada com sucesso!");
        } 
        catch (Exception e) {
            System.out.println("❌ Erro ao conectar com o banco de dados:");
            e.printStackTrace();
            Alerts.showAlert("Erro de Conexão", 
                    "Não foi possível conectar ao banco de dados", 
                    e.getMessage(), 
                    AlertType.ERROR);
            return;   // Interrompe se a conexão falhar
        }
        // =========================================================

        // Carrega a tela de Departments normalmente
        loadView("/gui/DepartmentList.fxml", (DepartmentListController controller) -> {
            controller.setDepartmentSevice(new DepartmentService());
            controller.updateTableView();
        });
    }
    
    @FXML
    public void onMenuItemAboutAction() {
        loadView("/gui/About.fxml", x -> {});
    }

    @Override
    public void initialize(URL uri, ResourceBundle rb) {
    }

    private synchronized <T> void loadView(String AbsoluteName, Consumer<T> initialingAction) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(AbsoluteName));
            VBox newVBox = loader.load();
            
            Scene mainScene = Main.getMainScene();
            VBox mainVBox = (VBox) ((ScrollPane) mainScene.getRoot()).getContent();
            
            Node mainMenu = mainVBox.getChildren().get(0);
            mainVBox.getChildren().clear();
            mainVBox.getChildren().add(mainMenu);
            mainVBox.getChildren().addAll(newVBox.getChildren());
            
            T controller = loader.getController();
            initialingAction.accept(controller);
            
        } catch (IOException e) {
            Alerts.showAlert("IOException", "Error loading view", e.getMessage(), AlertType.ERROR);		
        }
    }
}