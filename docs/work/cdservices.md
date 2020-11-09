##[Cloud- or device-based services or data:]()

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