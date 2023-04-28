# Azure Services Testing Application
The Azure Services Testing Application is a Java-based application developed to explore and test various Azure services.

It serves as a tool to gain familiarity with different Azure services and their capabilities before implementing the Cloud Adoption Framework.

## **Features**
The application currently supports the following Azure services:

1. **Service Bus**: test queues and messaging functionality.
2. **Key Vault**: access and manage secrets, keys, and certificates.
3. **Azure Storage Account**: generate tokens for uploading files and interact with blob storage.

## **Prerequisites**
Before running the application, ensure you have the following:

* Java Development Kit (JDK) installed.
* Azure subscription with the necessary permissions to access and manage the desired Azure services.

## **Getting Started**
To use the Azure Services Testing Application, follow these steps:

1. Clone the repository to your local machine.
2. Configure the application by providing the required properties in the **application.properties** file.
3. Build the application using your preferred Java build tool.
4. Run the application.

## **Configuration**
The application uses a **application.properties** file to store the necessary configuration. Update the properties in this file with your Azure service details:

```xml
azure.servicebus.connection-string=<your-service-bus-connection-string>
azure.keyvault.uri=<your-key-vault-uri>
azure.storage.account.name=<your-storage-account-name>
azure.storage.account.container-name=<your-storage-account-container-name>
```
>Ensure you have the correct values for the respective Azure services you want to test.

## **Usage**
Once the application is configured and running, you can interact with the different Azure services through the provided features:

* Service Bus: use the application to send and receive messages from queues, explore queue properties, and test messaging functionalities.
* Key Vault: access, manage, and store secrets, keys, and certificates securely. Retrieve, add, or update secrets and keys using the application.
* Azure Storage Account: generate tokens to upload files to the specified container in the Azure Storage Account. Explore blob storage functionalities.

## **Contributing**
Contributions to the Azure Services Testing Application are welcome! If you encounter any issues or have suggestions for improvements, please open an issue or submit a pull request.

## **License**
The Azure Services Testing Application is licensed under the MIT License.

## **Acknowledgments**
This application was developed as a learning tool to explore and understand Azure services.
Special thanks to the Microsoft Azure documentation and resources for providing valuable information.