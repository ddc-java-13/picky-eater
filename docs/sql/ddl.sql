CREATE TABLE IF NOT EXISTS `Recipe`
(
    `recipe_id`    INTEGER NOT NULL,
    `date_created` INTEGER,
    `updated`      INTEGER,
    `author`       TEXT,
    `recipe_name`  TEXT,
    `cuisine`      TEXT,
    PRIMARY KEY (`recipe_id`)

        CREATE INDEX IF NOT EXISTS
        `index_recipe_date_created` ON `Recipe` (`date_created`);

CREATE INDEX IF NOT EXISTS
    `index_recipe_updated` ON `Recipe` (`updated`);

CREATE INDEX IF NOT EXISTS
    `index_recipe_author` ON `Recipe` (`author`);

CREATE INDEX IF NOT EXISTS
    `index_recipe_recipe_name` ON `Recipe` (`recipe_name`);

CREATE INDEX IF NOT EXISTS
    `index_recipe_cuisine` ON `Recipe` (`cuisine`);


