package org.example.KeyVault;

import com.azure.identity.*;
import com.azure.security.keyvault.secrets.SecretClient;
import com.azure.security.keyvault.secrets.SecretClientBuilder;
import com.azure.security.keyvault.secrets.models.KeyVaultSecret;
import org.example.util.PropertiesUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class KeyVaultSample {
    public static void main(String[] args) {
        Logger LOGGER = LoggerFactory.getLogger(KeyVaultSample.class);
        String keyVaultUrl = PropertiesUtil.getProperty("app.key-vault-url");
        String clientId = PropertiesUtil.getProperty("app.client-id");
        String clientSecret = PropertiesUtil.getProperty("app.client-secret");
        String tenantId = PropertiesUtil.getProperty("app.tenant-id");

        ClientSecretCredential clientSecretCredential = new ClientSecretCredentialBuilder()
                .clientId(clientId)
                .clientSecret(clientSecret)
                .tenantId(tenantId)
                .build();

        SecretClient secretClient = new SecretClientBuilder()
                .vaultUrl(keyVaultUrl)
                .credential(clientSecretCredential)
                .buildClient();

        KeyVaultSecret secret = secretClient.getSecret("connectionString");
        KeyVaultSecret secret2 = secretClient.getSecret("queueName");

        LOGGER.info("\033[31mThe value of secret [" + secret.getName() + "] is: + " + secret.getValue() + "\033[0m");
        LOGGER.info("\033[31mThe value of secret [" + secret2.getName() + "] is: + " + secret2.getValue() + "\033[0m");
    }
}
