package jit.team;

 // Call this file with java --source 21 --enable-preview NoClass.java
    void main() {
            System.out.println("New instance main in unnamed class, without arg(s).");
            System.out.println("Is the class unnamed? "+this.getClass().isUnnamedClass());
            System.out.println("The class name is "+this.getClass().getName()+"...?");
            System.out.println("And the modifiers are ["+java.lang.reflect.Modifier.toString(this.getClass().getModifiers())+"]");
            System.out.println("(The package name is ["+this.getClass().getPackage().getName()+"])");
    }

