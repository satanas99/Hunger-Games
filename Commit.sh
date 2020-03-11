#!/bin/bash
echo "Donnez le nom du commit"
read commit

git add .
git config --global user.name "Satanas"
git config --global user.email "satanas06660@gmail.com"
git commit -m "$commit"
git push
echo "done"
