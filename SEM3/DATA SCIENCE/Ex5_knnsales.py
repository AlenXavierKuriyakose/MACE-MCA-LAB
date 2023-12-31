# -*- coding: utf-8 -*-
"""LAB5knnsales.ipynb

Automatically generated by Colaboratory.

Original file is located at
    https://colab.research.google.com/drive/1_zi6wVRCYOE44JgCJaQ_K2j2g4JH9Teh
"""

from google.colab import drive
drive.mount('/content/drive')

#Import libraries
import numpy as np
import pandas as pd
from sklearn.neighbors import KNeighborsRegressor
from sklearn.neighbors import KNeighborsRegressor

# Load the training dataset
train_data = pd.read_csv("/content/drive/MyDrive/dataset/Sales_Train - Sales_Train.csv")
# Load the test dataset
test_data = pd.read_csv("/content/drive/MyDrive/dataset/Sales_Test - Sales_Test.csv")

#missing data
train_data.isnull().sum()

#handle missing values
train_data.fillna(0, inplace=True)
test_data.fillna(0, inplace=True)

train_data.isnull().sum()

#encode categorical data
train_data=pd.get_dummies(train_data,columns=['Item_Fat_Content','Item_Type','Outlet_Size','Outlet_Location_Type','Outlet_Type'])
test_data=pd.get_dummies(test_data,columns=['Item_Fat_Content','Item_Type','Outlet_Size','Outlet_Location_Type','Outlet_Type'])



#split the train data to features and target
X=train_data.drop(['Item_Identifier','Outlet_Identifier','Item_Outlet_Sales'],axis=1)
Y=train_data['Item_Outlet_Sales']

# Ask the user for the value of 'k'
k = int(input("Enter the value of 'k' for the K-Nearest Neighbors algorithm: "))

#create the KNN model
knn=KNeighborsRegressor(n_neighbors=k)

#fitting
knn.fit(X, Y)

# Use the model to make predictions on the test data
X_test = test_data.drop(['Item_Identifier', 'Outlet_Identifier'], axis=1)
test_predictions = knn.predict(X_test)

from sklearn.metrics import mean_squared_error


# Define the true values
y_true = train_data['Item_Outlet_Sales']

# Calculate the RMSE
rmse = np.sqrt(mean_squared_error(y_true, knn.predict(X)))
print("Root Mean Square Error (RMSE):", rmse)

"""This is the average amount by which your model's predictions deviate from the actual values in the dataset."""

#submission file
submission = pd.DataFrame({'Item_Identifier': test_data['Item_Identifier'],
                            'Outlet_Identifier': test_data['Outlet_Identifier'],
                            'Item_Outlet_Sales': test_predictions})

submission.to_csv('sales_predictions.csv', index=False)

df=pd.read_csv('sales_predictions.csv')

print(df)

"""the output of KNN regression model provides predictions of product sales."""