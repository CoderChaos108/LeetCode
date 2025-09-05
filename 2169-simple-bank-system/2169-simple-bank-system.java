class Bank {
    long[] account;
    int n;

    public Bank(long[] balance) {
        account=balance;
        n=balance.length;
    }

    private boolean isValid(int acc) {
        return acc>=1&&acc<=n;
    }

    public boolean transfer(int account1,int account2,long money) {
        if(!isValid(account1)||!isValid(account2)) return false;
        if(account[account1-1]<money) return false;

        account[account1-1]=account[account1-1]-money;
        account[account2-1]=account[account2-1]+money;
        return true;
    }

    public boolean deposit(int acc,long money) {
        if(!isValid(acc)) return false;
        if(money<0) return false;

        account[acc-1]=account[acc-1]+money;
        return true;
    }

    public boolean withdraw(int acc,long money) {
        if(!isValid(acc)) return false;
        if(account[acc-1]<money) return false;

        account[acc-1]=account[acc-1]-money;
        return true;
    }
}
