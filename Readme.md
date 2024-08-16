# OTUS Java Basic Project

## Simple Go Client-Server

### Client-side

Simple Swing Interface

* Login Form
  * Fields: Username, Server IP
  * Buttons: Login
  * Sends login request to the server, displays message box on error, otherwise proceeds to the Lobby
* Lobby
  * User list
  * Challenge button
  * Sends or receives challenges, displays Challenge Window in modal
* Challenge Window
  * Displays the name of a user who sent the challenge or who you sent the challenge to
  * Displays Accept/Reject buttons for the challenge recipient, Displays Cancel button for the challenge sender
  * If the challenge is accepted, proceeds to Game Window
* Game Window
  * Displays names of the players
  * Displays whose move it is now
  * Displays a go board, number of captured stones
    * Clicking the board plays a move
    * Clicking Pass button passes
    * The board is redrawn for both players

### Server-side

* Accept messages via socket:
  * Login: respond with OK or error
  * User list: respond with user list
  * Send challenge: send message to target users
  * Accept challenge: send message to target users
  * Reject/cancel challenge: send message to target users, start the game
  * Play move: update board state and send it to both players