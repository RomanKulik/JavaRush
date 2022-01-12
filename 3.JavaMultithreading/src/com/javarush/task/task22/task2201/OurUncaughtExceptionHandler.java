package com.javarush.task.task22.task2201;

public class OurUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler {
    @Override
    public void uncaughtException(Thread t, Throwable e) {
        final String string = "%s : %s : %s";
        if (Solution.FIRST_THREAD_NAME.equals(t.getName())) {
            System.out.println(getFormattedStringForFirstThread(t, e, string));
        } else if (Solution.SECOND_THREAD_NAME.equals(t.getName())) {
            System.out.println(getFormattedStringForSecondThread(t, e, string));
        } else {
            System.out.println(getFormattedStringForOtherThread(t, e, string));
        }
    }

    // a) 1# : StringForFirstThreadTooShortException:
    // java.lang.StringIndexOutOfBoundsException: String index out of range: -1
    protected String getFormattedStringForOtherThread(Thread t, Throwable e, String string) {
        if (t.getName().equals(Solution.FIRST_THREAD_NAME))
            throw new StringForFirstThreadTooShortException();
        return null;
    }

    // б) java.lang.StringIndexOutOfBoundsException:
    // String index out of range: -1 : StringForSecondThreadTooShortException : 2#
    protected String getFormattedStringForSecondThread(Thread t, Throwable e, String string) {
        return null;
    }

    // в) RuntimeException : java.lang.StringIndexOutOfBoundsException:
    // String index out of range: -1 : 3#
    protected String getFormattedStringForFirstThread(Thread t, Throwable e, String string) {
        return null;
    }
}

/*
package com.javarush.task.task22.task2201;

public class OurUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler {
    @Override
    public void uncaughtException(Thread t, Throwable e) {
        final String string = "%s : %s : %s";
        if (Solution.FIRST_THREAD_NAME.equals(t.getName())) {
            System.out.println(getFormattedStringForFirstThread(t, e, string));
        } else if (Solution.SECOND_THREAD_NAME.equals(t.getName())) {
            System.out.println(getFormattedStringForSecondThread(t, e, string));
        } else {
            System.out.println(getFormattedStringForOtherThread(t, e, string));
        }
    }

    protected String getFormattedStringForOtherThread(Thread t, Throwable e, String string) {
        if (t.getName().equals(Solution.FIRST_THREAD_NAME))
            throw new StringForFirstThreadTooShortException();
        return null;
    }

    protected String getFormattedStringForSecondThread(Thread t, Throwable e, String string) {
        return null;
    }

    protected String getFormattedStringForFirstThread(Thread t, Throwable e, String string) {
        return null;
    }
}

*/