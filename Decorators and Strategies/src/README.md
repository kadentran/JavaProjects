# Changes

## ShoppingCart

Added a ShoppingCart concept that will provide additional functionality for price and points calculations.

## Coupons

Used the Decorator pattern to implement coupons that can be applied to the total cost of the ShoppingCart.  Two coupons have been implemented:

* Half-off: This will apply a 50% discount to the total of the shopping cart
* \$10 off: This will take \$10 off of the total of the shopping cart if the total is more than $50 before the coupon is applied.

## Homework-5 Instructions

### DECORATORS and STRATEGIES

In this homework, you are required to use the code for the movie rental application and add the following features:

1) Implementing the following two new policies for a coupon system:
a. A coupon for a rental that allows 50% off the entire rental price.
b. A coupon for a rental that takes \$10 off for a total rental of more than \$50.
2) For frequent rental points, you are required to add two new strategies:
a. A new frequent rental point computation gives double regular points to any customer who is renting both regular and children movies
b. A new frequent rental point computation gives double regular points to any customer who is 18-22 and renting one or multiple new release movies.
3) Please modify your code to add the following functionality: if a customer has 10 frequent renter points, he will get a free movie rental of any type.