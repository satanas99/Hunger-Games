#!/bin/bash

#Fait un commit en demandant le nom du commit
echo "Donnez le nom du commit"
read commit

git add .
echo "===> Creation des config ..."
git config --global user.name "Satanas"
git config --global user.email "satanas06660@gmail.com"
echo "Fait"
echo "===> Creation du commit et push sur github ..."
git commit -m "$commit"
git push

