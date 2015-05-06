#Sixes Wild
[![Build Status](https://travis-ci.org/arthurlockman/sixeswild.svg?branch=master)](https://travis-ci.org/arthurlockman/sixeswild)
[![Coverage Status](https://coveralls.io/repos/arthurlockman/sixeswild/badge.svg?branch=master)](https://coveralls.io/r/arthurlockman/sixeswild?branch=master)

Sixes Wild is a game of numbers. The goal of the game is to connect tiles whose numbers add to 6. This can be done in a myriad of level types, each with its own level goal. Try them all!

![Sixes Wild Game](/src/main/resources/view/game.png?raw=true "Game Screenshot")

##Game Instructions

* When you load a level, you will see a board with 81 squares. The squares will either be active or inactive. You earn points by connecting active squares, but be careful - inactive squares are barriers and cannot be selected.
* Each active square contains a number and a multiplier. The score you earn from a basic move is determined by the following equation:  move points = [sum of numbers] x [product of multipliers] x 10.
* When you make a move, the squares you selected will disappear and new tiles will fall down to replace them. Moves are only valid if the sum of the selected squares equals 6, but squares that have the number 6 cannot be removed!
* Levels are won by reaching a certain number of total points and meeting another special level requirement. For all levels, you can achieve 1-star, 2-star, and 3-star victories depending on how many points you earn. The special level requirement will depend on what type of level you are playing:  Lightning, Puzzle, Elimination, or Release.
* In a Lightning level, you must win at least one star before the timer runs out. Puzzle levels, on the other hand, give you a limited number of moves with which to play. In an Elimination level, you have to perform a basic move on every active square in the board. And in Release levels, you need to fill every "bucket" with a square that has the number 6.
* Sixes Wild has three special moves:  Swap, Remove, and Reset. Swap allows you to swap the positions of two neighboring squares, Remove allows you to delete a square from the board, and Reset allows you to reset the entire game board. Special moves can help you win the game, but use your special moves strategically - you only have a few of them.

##Builder Instructions

* To create a new level, press the New Level button. To edit an existing level, click the Edit Level button. Both buttons will take you to the level editor. 
* Once in the level editor, you will see a grid of 81 squares. These squares can be set as Active, Inactive, Bucket, or Six. Active squares can hold numbered tiles, whereas Inactive Squares cannot. Inactive squares typically serve as obstacles. The Bucket square and Six square options are only accessible when editing a Release level. Undo and redo buttons for square edits can be found in the top-right corner of the level editor window.
* You will also see a number of options under Settings. Here, you can change the level type, which will in turn allow you to set a time or move limit depending on which level type you selected. You can also set the scores necessary for achieving two-star and three-star victories when playing this level.
* To allow special moves for the level you are editing, simply check the Allow Special Moves box, located in the Settings section. And to set the frequency of numbered tiles and their multipliers, click on the Set Frequencies button. 
* You may choose to save your changes or exit the level editor at any time. You may also preview the level you created by hitting the Preview button. Once you are done editing a level, just save and exit the Builder application and start the Sixes Wild Player.

##Running
The executables in our project are as follows:

* *src/main/java/application/BuilderLauncher.java:* The builder program.
* *src/main/java/application/PlayerLauncher.java:* The player program.

Both targets can be built in Eclipse, but also in gradle using the following command:

    ./gradlew run

##Gradle
Our project uses the Gradle build system. Below is a list of the relevant gradle targets and what each of them does

* *player* The player gradle task will run the game itself and allow users to play it.
* *builder* The builder task will start the level builder and allow users to modify or create new levels.
* *test* The test task will run the suite of unit tests.
* *jacocoTestReport* The JacocoTestReport task must be run after the test task, and will generate an HTML and XML test coverage report in the build directory of the project.

To run one of these targets from the command line, type the following:

    ./gradlew [desired target]
