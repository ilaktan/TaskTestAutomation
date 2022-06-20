package Chetwood.utilities;

import Chetwood.pages.*;
public class Pages {

    GenericFunctions genericFunctions;
    Login login;
    GetQuickQuote getQuickQuote;


    public GenericFunctions genericFunctions() {
        if (genericFunctions == null) {
            genericFunctions = new GenericFunctions();
        }
        return genericFunctions;
    }

    public Login login() {
        if (login == null) {
            login = new Login();
        }
        return login;
    }
    public GetQuickQuote getQuickQuote() {
        if (getQuickQuote == null) {
            getQuickQuote = new GetQuickQuote();
        }
        return getQuickQuote;
    }


}
