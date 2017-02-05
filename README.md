# Bank Kata to illustrate Outside-In TDD

This is the Bank Kata implemented with the aim of following Sandro Mancuso's example of Outside-in TDD from https://www.youtube.com/watch?v=XHnuMjah6ps

All credit for this should go to Mancuso and Codurance. I'm just going through this kata for my own benefit.

Following the method, we start with an Acceptance Test, create stubs for any delegates and work on the acceptance test until it fails for the right reason.

## Problem Description - Bank Kata

Create a simple bank application with the following features:

- Deposit into account
- Withdraw from account
- Print a bank statement (transaction history in desc date order) to the console

## Acceptance criteria

A Statement should have the following the format:
    DATE       | AMOUNT  | BALANCE
  10/04/2014 | 500.00  | 1400.00
  02/04/2014 | -100.00 | 900.00
  01/04/2014 | 1000.00 | 1000.00

## Steps in exercising the Kata

We start by creating an acceptance test. This is PrintStatementFeature.
The main thing we know is the format of the statement - it's the obvious side-effect to test for. So we start with print_statement_containing_all_transactions.

We choose to verify against console output. But how will we do this? It could be awkward with the Java console so the natural choice seems to be abstract from it with our own Console class (which might just act as an intermediary).

So Console is our first delegate. That means we need to stub it and Mock it in our acceptance test.

