package org.example.StorageAccount;

import com.azure.storage.blob.BlobContainerClient;
import com.azure.storage.blob.BlobContainerClientBuilder;
import com.azure.storage.blob.sas.BlobSasPermission;
import com.azure.storage.blob.sas.BlobServiceSasSignatureValues;
import org.example.util.PropertiesUtil;

import java.time.OffsetDateTime;
import java.time.temporal.ChronoUnit;

public class SASGenerator {
    public static void main(String[] args) {
        String storageConnectionString = PropertiesUtil.getProperty("azure.storage.account.connection-string");
        String containerName = PropertiesUtil.getProperty("azure.storage.account.container-name");

        BlobContainerClient containerClient = new BlobContainerClientBuilder()
                .connectionString(storageConnectionString)
                .containerName(containerName)
                .buildClient();

        String sasToken = generateSasToken(containerClient);
        System.out.println("Generated SAS Token: " + sasToken);
    }

    private static String generateSasToken(BlobContainerClient containerClient) {
        BlobSasPermission permission = new BlobSasPermission()
                .setReadPermission(true)
                .setWritePermission(true)
                .setDeletePermission(true)
                .setCreatePermission(true);

        OffsetDateTime expiryTime = OffsetDateTime.now().plus(1, ChronoUnit.DAYS);

        /*
         * setContainerName is deprecated, but it is retrieved from the BlobContainerClient instance instead of being set explicitly.
         * This ensures that the correct container name is used.
         */

        BlobServiceSasSignatureValues sasValues = new BlobServiceSasSignatureValues(expiryTime, permission)
                .setContainerName(containerClient.getBlobContainerName());

        return containerClient.generateSas(sasValues);
    }
}
