package downloader;

import com.sun.deploy.ui.ProgressDialog;
import downloader.classes.DLPrefs;
import downloader.classes.ImageRow;
import downloader.jobs.DownloadImage;
import downloader.jobs.ExtractImagesURL;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.stage.DirectoryChooser;

import javax.management.Notification;
import java.io.File;
import java.nio.file.Paths;
import java.util.ArrayList;

public class Controller {
    @FXML
    BorderPane rootPane;

    @FXML
    TextArea urlListTA;

    @FXML
    Label savedFolderLabel;
    @FXML
    TableView<ImageRow> resultTable;
    @FXML
    TableColumn<ImageRow, String> nameCol;

    @FXML
    TableColumn<ImageRow, Integer> widthCol;

    @FXML
    TableColumn<ImageRow, Integer> heightCol;




    public void selectSavedFolder()
    {
        DirectoryChooser chooser = new DirectoryChooser();
        chooser.setTitle("Select directory to store your database");
        File file = chooser.showDialog(rootPane.getScene().getWindow());

        if (file==null)
            return;

        if (!file.exists())
        {
            Paths.get(file.getAbsolutePath());
            DLPrefs.setString(DLPrefs.SAVE_LOCATION, file.getAbsolutePath());
        } else
        {
            DLPrefs.setString(DLPrefs.SAVE_LOCATION, file.getAbsolutePath());
        }

        savedFolderLabel.setText(file.getAbsolutePath());

    }

    public void startDownload()
    {
        if (DLPrefs.getString(DLPrefs.SAVE_LOCATION).equals(""))
        {
            System.out.println("set location first");
            return;
        }

        Task<Void> task = new Task<Void>() {
            @Override
            protected Void call() throws Exception {
                String[] urlList = urlListTA.getText().trim().split("\n");

                int counter = 1;
                for (String url : urlList)
                {
                    updateMessage("Downloading url " + counter + " of " + urlList.length);
                    try
                    {
                        ArrayList<String> imageURLs = ExtractImagesURL.getURLs(url);
                        for (String imageURL: imageURLs)
                        {
                            DownloadImage.saveImage(DLPrefs.getString(DLPrefs.SAVE_LOCATION), imageURL);
                        }
                    } catch (Exception ex)
                    {
                        ex.printStackTrace();
                    }

                }

                return null;
            }
        };

        org.controlsfx.dialog.ProgressDialog dialog = new org.controlsfx.dialog.ProgressDialog(task);
        dialog.setTitle("Download Images");

        new Thread(task).start();
    }

}
