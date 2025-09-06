# Minesweeper

## How to Play
To start the game, select a tile and "uncover" it. The first tile that is uncovered will always be safe (not a mine) An uncovered tile will either be a mine, space, or number. If a mine is uncovered, you lose. If a space is uncovered, all tiles around the space is also uncovered. A number tile signifies the number of mines surrounding (both orthogonally and diagonally) that number tile. Players may choose to flag a tile as a mine. Tiles that are flagged can not be uncovered. The game ends when the player uncovers a mine or all non-mine tiles.

Enter a set of coordinates to open that tile. Accepted inputs must be 2 numbers serperated by a comma. Parenthesis and Spaces are all ignored. For the sake of not using try-catch for the AP Comupter Science Course, the code assumes all inputs are valid inputs. 
To flag a tile, enter "f" or "F" as the first character (ex. "f0,0", "f 0,0", "F (0, 0)", etc). Players may choose to flag tiles before uncovering a single cell.
When te program automatically uncover cells surrounding a "0" (or "void"), flags will remain covered. 

# Project Description / Requirements
