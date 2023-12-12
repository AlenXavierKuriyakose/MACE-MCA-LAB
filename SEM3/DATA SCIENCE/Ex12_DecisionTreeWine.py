import pandas as pd
import seaborn as sns
import matplotlib.pyplot as plt
from sklearn.model_selection import train_test_split
from sklearn.tree import DecisionTreeClassifier, plot_tree
from sklearn import metrics
from sklearn.preprocessing import LabelEncoder

# Load the Wine Quality dataset
wine_data = pd.read_csv("WineQuality.csv")

# Encode the 'type' column to numerical values
label_encoder = LabelEncoder()
wine_data['type'] = label_encoder.fit_transform(wine_data['type'])

# Select features and target variable
selected_features = [
    'type', 'fixed acidity', 'volatile acidity', 'citric acid', 'residual sugar',
    'chlorides', 'free sulfur dioxide', 'total sulfur dioxide', 'density', 'pH',
    'sulphates', 'alcohol'
]

X = wine_data[selected_features]
y = wine_data['quality']

# Split the dataset into training and testing sets
X_train, X_test, y_train, y_test = train_test_split(X, y, test_size=0.2, random_state=42)

# Create a decision tree classifier
clf = DecisionTreeClassifier()

# Train the classifier on the training set
clf.fit(X_train, y_train)

# Make predictions on the test set
y_pred = clf.predict(X_test)

# Evaluate the performance of the model
accuracy = metrics.accuracy_score(y_test, y_pred)
print(f"Accuracy: {accuracy:.2f}")

# Display the confusion matrix as a heatmap
conf_matrix = metrics.confusion_matrix(y_test, y_pred)
plt.figure(figsize=(8, 6))
sns.heatmap(conf_matrix, annot=True, fmt="d", cmap="Blues", xticklabels=sorted(wine_data['quality'].unique()), yticklabels=sorted(wine_data['quality'].unique()))
plt.xlabel('Predicted Quality')
plt.ylabel('True Quality')
plt.title('Confusion Matrix Heatmap')
plt.show()

# Plot the decision tree
plt.figure(figsize=(15, 10))
plot_tree(clf, max_depth=5, feature_names=selected_features, class_names=sorted(wine_data['quality'].astype(str).unique()), filled=True, rounded=True)
plt.title("Decision Tree")
plt.show()