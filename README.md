# Tic-Tac-Toe with AI

A GUI Tic-Tac-Toe game that uses the Minimax algorithm which allows the AI to find the best move using the alpha-beta-pruning method and returns a heuristic value.

## Demo

![demo](https://user-images.githubusercontent.com/60388555/103140236-47f08480-46b2-11eb-863c-4c8dbaa6e175.gif)

## Installation

Download and run either the 
[exe](https://github.com/cengizozel/Tic-Tac-Toe-with-AI/raw/main/exe/Tic-Tac-Toe.exe)
or
[jar](https://github.com/cengizozel/Tic-Tac-Toe-with-AI/raw/main/exe/Tic-Tac-Toe.jar)
file.

## Usage

This game allows the user to pick between playing against another person (2 Players) or an AI (1 Player). When '1 Player' is selected, the user can choose between a range of difficulties.

The difficulties are:  
**Random:** Moves are completely random.  
**Easy:** 25% chance of making a perfect move.  
**Medium:** 50% chance of making a perfect move.  
**Hard:** 75% chance of making a perfect move.  
**Impossible:** 100% chance of making a perfect move.  

## Minimax Algorithm
Tic Tac Toe is a zero-sum game which means the gain or loss of each player is balanced with the loss or gain (respectively) of the other. This project uses a recursive algorithm
