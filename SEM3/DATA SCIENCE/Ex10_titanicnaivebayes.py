# -*- coding: utf-8 -*-
"""LAB11titanicnaivebayes.ipynb

Automatically generated by Colaboratory.

Original file is located at
    https://colab.research.google.com/drive/1t13rr6Itb2odb7H7Qho4W6unacrKg8FQ
"""

import pandas as pd
from sklearn.model_selection import train_test_split
from sklearn.naive_bayes import GaussianNB
from sklearn.metrics import accuracy_score,confusion_matrix,classification_report

train_data = pd.read_csv('/content/drive/MyDrive/dataset/Titanic_Train - Titanic_Train.csv')
test_data = pd.read_csv('/content/drive/MyDrive/dataset/Titanic_Test - Titanic_Test.csv')

train_data.head()

test_data.head()

# Encode categorical variables using Label Encoding
from sklearn.preprocessing import LabelEncoder

label_encoder = LabelEncoder()

train_data['Sex'] = label_encoder.fit_transform(train_data['Sex'])
test_data['Sex'] = label_encoder.transform(test_data['Sex'])

train_data['Embarked'] = label_encoder.fit_transform(train_data['Embarked'])
test_data['Embarked'] = label_encoder.transform(test_data['Embarked'])

#removing null values
train_data.fillna(0,inplace=True)
test_data.fillna(0,inplace=True)

test_data.isnull().sum()

train_data.isnull().sum()

train_data.head(5)

#spliting the training and testing data
features = ['Pclass', 'Age', 'SibSp', 'Parch', 'Fare','Sex','Embarked']
X_train = train_data[features]
y_train = train_data['Survived']
X_test = test_data[features]

# Create and train the Naive Bayes model
nb= GaussianNB()
nb.fit(X_train, y_train)

#make prediction
y_train_pred = nb.predict(X_train)
y_test_pred = nb.predict(X_test)
accuracy = accuracy_score(y_train, y_train_pred)
print(f"Accuracy on the training dataset: {accuracy}")

X_test.head(5)

#unseen
res=[[3, 34.5, 0, 0, 7.8292, 1, 1]]
pred=nb.predict(res)
result=pred[0]
if result == 0:
  print("Not Survived")
elif result == 1:
  print("Survived")