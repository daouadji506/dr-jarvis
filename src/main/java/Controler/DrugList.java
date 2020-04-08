package Controler;

import com.jfoenix.controls.JFXButton;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.ComboBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import model.drug;
import model.prescription;

import java.net.URL;
import java.util.ResourceBundle;

public class DrugList  implements Initializable {
    public TableView<drug> drug_table;
    public TableColumn<drug,String> name_C;
    public TableColumn<drug,String>  type_C;
    public TableColumn<drug,String>  doss_C;
    public TableColumn<drug,String>  code_C;
    public TableColumn<drug, JFXButton>  notice_C;
    public TableColumn<drug,SplitMenuButton> menu_C;


    @Override
      public void initialize(URL location, ResourceBundle resources) {
        initCol();
        loadData();
        edit_table();
    }
    public void initCol(){
        name_C.setCellValueFactory(new PropertyValueFactory<>("name"));
        type_C.setCellValueFactory(new PropertyValueFactory<>("type"));
        doss_C.setCellValueFactory(new PropertyValueFactory<>("doss"));
        code_C.setCellValueFactory(new PropertyValueFactory<>("code"));
        notice_C.setCellValueFactory(new PropertyValueFactory<>("notice"));
        menu_C.setCellValueFactory(new PropertyValueFactory<>("menu"));

    }
    public void  loadData(){
        ObservableList<drug> data = FXCollections.observableArrayList();
        data.add(new drug("Cocayin","pills","25mg","3",new JFXButton(),new SplitMenuButton()));
        data.add(new drug("sarou5","dwa","siro","1000mg",new JFXButton(),new SplitMenuButton()));
        drug_table.setItems(data);

    }
    public void edit_table(){
        ObservableList<String> type_list = FXCollections.observableArrayList("pills","dwa");
        ObservableList<String> doss_list = FXCollections.observableArrayList("250mg","100mg");
        type_C.setCellFactory(ComboBoxTableCell.forTableColumn(type_list));
        doss_C.setCellFactory(ComboBoxTableCell.forTableColumn(doss_list));

        drug_table.setEditable(true);
    }

    public void add_drug_table(ActionEvent actionEvent) {
    }
}
