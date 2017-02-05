# Bank Kata to illustrate Outside-In TDD

This is the Bank Kata implemented with the aim of following Sandro Mancuso's example of Outside-in TDD from https://www.youtube.com/watch?v=XHnuMjah6ps

All credit for this should go to Mancuso and Codurance. I'm just going through this kata for my own benefit.

Following the method, we start with an Acceptance Test, create stubs for any delegates (shells with stubbed methods) and work on the acceptance test until it fails for the right reason.

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

## Constraints

We have to have a class Account with the following void methods

deposit(int amount), withdraw(int amount), printStatement()

We are not allowed to add any futher public methods to Account. We don't want to add extra getters to help us test it, we test from the outside - the side-effects.

We use Strings and integers for dates and amounts to keep things simple.

We're allowed to take liberties with whitespace in the statement (again to keep things simple).

## Movements in exercising the Kata

### First Movement - print_statement_containing_all_transactions on the PrintStatementFeature Acceptance Test

We start by creating an acceptance test. This is PrintStatementFeature.
The main thing we know is the format of the statement - it's the obvious side-effect to test for. So we start with print_statement_containing_all_transactions.

We choose to verify against console output. But how will we do this? It could be awkward with the Java console so the natural choice seems to be abstract from it with our own Console class (which might just act as an intermediary).

So Console is our first delegate. We want to stub it and Mock it in our acceptance test. Console will remain mocked in our PrintStatementFeature acceptance as Console is part of the external world as far as the print statement feature goes.

Initially Console's printLine method will throw new UnsupportedOperationException. This is because we are only going to mock that method from the Feature for now so we don't need an implementation and we don't want to implement it until we get to it.

What we do want to test without a mock in the PrintStatementFeature is the Account class, as that is meant to have the printStatement method.

The PrintStatementFeature will be failing for the right reason when it throws "Wanted but not invoked" for printLine. Naturally nothing does call printLine yet. For it to get called we're going to need to inject our Console mock somehow but we haven't decided how upfront.

Will we inject console into Account or into something else? We don't want to decide that yet. Next step is to consider how to unit test account and let the decision come out as we go along.
