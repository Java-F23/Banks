# Bank System - Mohamed Hashish - 900201220
Banking System in implemented in Java

Sprint 1: (1/10/2023 -> 15/10/2023):
- All requirements were implemented successfully and pushed on 14/10/2023
- ChatGPT Conversation link: https://chat.openai.com/share/1a33f30f-8e77-4c30-b001-b096b8a12f45

Sprint 2: (15/10/2023 -> 29/10/2023):
- All requirements were implemented successfully and pushed on 30/10/2023
- ChatGPT Conversation link: https://chat.openai.com/share/085befa2-fe39-4f9c-936e-7a91a3d2de23

Sprint 3: (11/11/2023 -> 26/11/2023):
- All requirements were implemented successfully and pushed on 26/11/2023
- ChatGPT Conversation links:
  * https://chat.openai.com/share/8ec98a03-b588-4452-83fc-6f0adfce40f6
  * https://chat.openai.com/share/085befa2-fe39-4f9c-936e-7a91a3d2de23
- Changes made in Sprint 3 with justification:
  * Controllers were introduced and implemented in the parts that contained complex data such as the admin and customer classes, with other additional ones. Not all GUI components needed to have a controller since they were simple.
  * Sample data are provided using: customers.csv, accounts.csv, and accountTypes.csv.
  * Source code was refactored by removing any unused declared variables/functions, large commented blocks of codes that used to exist, and any unused parameters.
  * Some functionalities were improved and bugs were fixed, for example: handling cases of empty text boxes.
  * All println() functions were removed.
- Structure of CSV Files:
  * customers.csv: **ID**  **Name**
  * accounts.csv: **accountNumber**  **accountType**  **balance**  **customerID**
  * accountTypes.csv: **type_number**  **type_description**
