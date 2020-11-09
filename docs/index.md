## Project description

SmartCheff is an app that allows the user to input any amount of ingredients manually or with the camera if the ingredient has a barcode. After the user has inputted the ingredients of their choice and selected the search button, recipes are presented that include the ingredients inputted.
Picture being a student with the classic ingredient Top Ramen. When Top Ramen is selected as 
an ingredient SmartCheff will display all the delicious ways to cook your Top Ramen.

 * Recipe lookup: When a user inputs the ingredients, the app will generate a list of recipes that include the selected ingredients.
 * The use of the users' camera: The camera will be used to input products as an ingredient by scanning the barcode of a product.
 * Ability to save recipes and ingredients used.

## Cloud- or device-based services or data:
* Users camera: 
  * The camera will be used to input products as an ingredient by scanning the barcode of a product.
  * <https://developer.android.com/reference/android/hardware/Camera>
   * This app will be able to function without the camera but will not be able to input products as ingredients using a barcode.
   
* Bar code monster Api:
  * <https://rapidapi.com/jonata/api/barcode-monster/endpoints>
  * This web service will allow the app to look up a product using a upc barcode, so i can then input the product as an ingredient.
  * This app will be able to function without this service, but the camera input of an ingredient will not.
 
* Spoonacular Api:
  * <https://spoonacular.com/food-api/docs>
  * This web service will allow the app to use the inputted ingredients in a search of recipes.
  * The app will not function without this service.

## [Intended users](work/intendedusers.md)

## [Wireframe diagram](work/wireframe.md)

## [Entity-Relationship Diagram](work/ERD.md)

## [Entity classes](work/entityclasses.md)
