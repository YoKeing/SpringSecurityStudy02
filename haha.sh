#!/bin/bash

git init
git add ./*
git commit -am 'update'
git remote add origin git@github.com:YoKeing/SpringSecurityStudy02.git
git push origin master

echo -e '\n\nDown!\n\n'

