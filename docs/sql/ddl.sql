CREATE TABLE IF NOT EXISTS `Recipe`
(
    `recipe_id`        INTEGER PRIMARY KEY AUTOINCREMENT,
    `user_id`          INTEGER NOT NULL,
    `external_key`     INTEGER NOT NULL,
    `instructions`     TEXT,
    `name`             TEXT    NOT NULL,
    `image`            TEXT,
    `prep_time`        INTEGER NOT NULL,
    `skill_level`      INTEGER NOT NULL,
    `serving_quantity` INTEGER NOT NULL,
    FOREIGN KEY (`user_id`) REFERENCES `User` (`user_id`) ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE UNIQUE INDEX IF NOT EXISTS `index_Recipe_external_key` ON `Recipe` (`external_key`);

CREATE INDEX IF NOT EXISTS `index_Recipe_user_id` ON `Recipe` (`user_id`);

CREATE TABLE IF NOT EXISTS `Ingredient`
(
    `ingredient_id`      INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
    `user_id`            INTEGER                           NOT NULL,
    `quantity_available` INTEGER                           NOT NULL,
    `upc`                TEXT,
    `name`               TEXT                              NOT NULL,
    FOREIGN KEY (`user_id`) REFERENCES `User` (`user_id`) ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE INDEX IF NOT EXISTS `index_Ingredient_user_id` ON `Ingredient` (`user_id`);

CREATE TABLE IF NOT EXISTS `User`
(
    `user_id`   INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
    `oauth_key` TEXT
);

CREATE INDEX IF NOT EXISTS `index_User_oauth_key` ON `User` (`oauth_key`);

CREATE TABLE IF NOT EXISTS `RecipeIngredient`
(
    `recipe_ingredient_id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
    `ingredient_id`        INTEGER                           NOT NULL,
    `recipe_id`            INTEGER                           NOT NULL,
    FOREIGN KEY (`ingredient_id`) REFERENCES `Ingredient` (`ingredient_id`) ON UPDATE CASCADE ON DELETE CASCADE,
    FOREIGN KEY (`recipe_id`) REFERENCES `Recipe` (`recipe_id`) ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE INDEX IF NOT EXISTS `index_RecipeIngredient_ingredient_id` ON `RecipeIngredient` (`ingredient_id`);

CREATE INDEX IF NOT EXISTS `index_RecipeIngredient_recipe_id` ON `RecipeIngredient` (`recipe_id`);
