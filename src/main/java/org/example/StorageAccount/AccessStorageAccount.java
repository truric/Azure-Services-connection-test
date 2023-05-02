package org.example.StorageAccount;

import com.azure.storage.blob.*;
import org.example.util.PropertiesUtil;

import java.io.File;

public class AccessStorageAccount {
    public static void main(String[] args) {
        String sasToken = PropertiesUtil.getProperty("azure.storage.account.sas-token");
        String blobName = PropertiesUtil.getProperty("azure.storage.account.blob");
        String storageEndpoint = PropertiesUtil.getProperty("azure.storage.account.endpoint");
        String filePath = PropertiesUtil.getProperty("azure.storage.file-path");

        String blobUrl = storageEndpoint + "/" + blobName + "?" + sasToken;

        BlobClient blobClient = new BlobClientBuilder().endpoint(blobUrl).buildClient();


        File fileToUpload = new File(filePath);
        blobClient.uploadFromFile(fileToUpload.getAbsolutePath());

    }
}
