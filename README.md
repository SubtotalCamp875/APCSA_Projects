# Minesweeper

## How to Play:
To start the game, select a tile and "uncover" it. The first tile that is uncovered will always be safe (not a mine) An uncovered tile will either be a mine, space, or number. If a mine is uncovered, you lose. If a space is uncovered, all tiles around the space is also uncovered. A number tile signifies the number of mines surrounding (both orthogonally and diagonally) that number tile. Players may choose to flag a tile as a mine. Tiles that are flagged can not be uncovered. The game ends when the player uncovers a mine or all non-mine tiles.

Enter a set of coordinates to open that tile. Accepted inputs must be 2 numbers serperated by a comma. Parenthesis and Spaces are all ignored. For the sake of not using try-catch for the AP Comupter Science Course, the code assumes all inputs are valid inputs. 
To flag a tile, enter "f" or "F" as the first character (ex. "f0,0", "f 0,0", "F (0, 0)", etc). Players may choose to flag tiles before uncovering a single cell.
When the program automatically uncover cells surrounding a "0" (or "void"), flags will remain covered. 

# Project Description / Requirements:
For thsi project, your aim is to create minesweeper within the terminal. 
- The board size should be 9x9 with 8 mines.
- You will propmt the user to input a set of coordinates before generating and an array.
  * Assume all inputs are valid inputs. Valid inputs will ignore all spaces and parenthesis, 2 numbers will be seperated by a comma, and there can be a upper or lower case "f" at the 0th index.
- inputs where "f" is in the first index will toggle whether or not a tile is flagged
  * When a player flags a tile, that tile can not be opened automatically or manually until that tile is unflagged.
- If a "0" or "void" tile is opened, all the surrounding tiles should automatically be opened (Unless flagged).
- The printed board should display the x and y coordinate surrounded in brackets both sides and bottom. Coordinates will start with index 0.
- The game automatically ends with a win or lose messaage if a the user opens all tiles (except mines) or clicks on a mine.

# Bonus:
- Make the tiles color coded. (You may use color files from google)
- Add a config file so specific variables (that are used globally in the program) can be changed.
