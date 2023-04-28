package org.example.StorageAccount;

import com.azure.storage.blob.*;
import org.example.util.PropertiesUtil;

import java.io.File;

public class AccessStorageAccount {
    public static void main(String[] args) {
        String sasToken = PropertiesUtil.getProperty("azure.storage.account.sas-token");
        String blobName = PropertiesUtil.getProperty("azure.storage.account.blob");
        String storageEndpoint = PropertiesUtil.getProperty("azure.storage.account.endpoint");

        String blobUrl = storageEndpoint + "/" + blobName + "?" + sasToken;

        BlobClient blobClient = new BlobClientBuilder().endpoint(blobUrl).buildClient();


        File fileToUpload = new File("C:\\Users\\RP\\Desktop\\azureServicesConnection\\src\\main\\resources\\thumbnail.png");
        blobClient.uploadFromFile(fileToUpload.getAbsolutePath());

    }
}
