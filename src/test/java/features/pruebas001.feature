Feature: Pagina Swag Labs
COMO usuario QUIERO ingresar con mis credenciales PARA hacer compras

  Scenario Outline: Llegar hasta el carrito de compras
  Given El usuario esta en la Home de Swag Labs
  When Ingresa sus credenciales de usuario
    And Accede a la pagina de compras
    And Selecciona el producto "<producto1>"
    And Selecciona el producto "<producto2>"
    And Deselecciona el producto "<producto3>"
    And Da clic en la opcion de "<pagina2nombre>"
    Then Accede a la pagina con el titulo "<pagina2titulo>"
    Examples:
    | producto1               | producto2                  | producto3                 | pagina2nombre   | pagina2titulo |
    | Sauce Labs Backpack     | Sauce Labs Bike Light      | Sauce Labs Backpack       | cart            | Your Cart     |
    | Sauce Labs Bolt T-Shirt | Sauce Labs Fleece Jacket   | Sauce Labs Fleece Jacket  | cart            | Your Cart     |
    | Sauce Labs Backpack     | Sauce Labs Bike Light      | Sauce Labs Bike Light    | cart            | Your Cart     |
