package com.kma.ImageTool.Model.naming;

import java.util.regex.Matcher;

/**
 * Social Glutton (c) 2014
 * Created by mhontar on 04.07.14.
 */
public class MatcherWrapper {
    final Matcher matcher;
    final String regex;

    public MatcherWrapper(Matcher matcher, String regex) {
        this.matcher = matcher;
        this.regex = regex;
    }

    public Matcher getMatcher() {
        return matcher;
    }

    public String getRegex() {
        return regex;
    }
}
