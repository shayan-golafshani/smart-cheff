# [Entity classes](https://github.com/Alex-Garber/smart-cheff/tree/master/app/src/main/java/edu/cnm/deepdive/smartcheff/model/entity)

## User 
The User entity represents the User of the application. 
This entity has only two attributes, the user id which is used to identify A specific user
and the Oauth Key which will be used as authentication with google sign in.
## Ingredient
The Ingredient entity represents any ingredient that is used by the user.
The Ingredient entity has a total of four ingredient attributes and one foreign key attribute that links to the User entity.
Ingredient id is used to identify a specific ingredient. Quantity available is the total amount of an ingredient the user has on hand.
Upc is only relevant if the user wants to input an ingredient using the camera. The ingredient has to have a barcode.
The name is an attribute that is simply the name of the ingredient.
## Recipe
The Recipe entity used to represent any Recipe.
The Recipe entity has a total of 6 recipe attributes and one foreign key that links the User entity.
The recipe id attribute is used to identify a specific Recipe. Instructions are the instructions used to create A recipe.
Serving size is the total serving that one recipe might create.
The skill level is the difficulty of any given recipe.
The Name attribute is simply the name of the Recipe.
## RecipeIngredient
The RecipeIngredient entity is the joining table between Recipe and ingredient.
This entity only has a Primary key attribute and two foreign key attributes.