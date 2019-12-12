# tcss390dana
DANA - TCSS 390 AU 19

**Duy's Note (if you don't use Eclipse):**
1. Beware which branch you are on. You can check by:  
> `git branch`  
2. To see all branches. You can check by:
> `git branch -r`
3. To create a new branch, type:
> `git checkout -b (YourBranchName)``
4. To switch to your branch, type:
> `git checkout (YourBranchName)``
5. To push your code into your branch, here is the common order:
> `git checkout (YourBranchName)`  
> `git -add (YourModifiedFileName)`  
> `git -commit -m "(JustTypeInAMessage)"`  
> `git push`
6. To pull code from master to your branch, type:
> `git checkout (YourBranchName)`  
> `git fetch origin`  
> `git pull origin master`

As you see, we usually write our code in our own branches to avoid unnecessary conflict in master branch.
