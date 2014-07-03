package com.kma.ImageTool.Model.naming.strategy.impl;

import com.kma.ImageTool.Model.naming.Constants;
import com.kma.ImageTool.Model.naming.MatcherWrapper;
import com.kma.ImageTool.Model.naming.strategy.INamingStrategy;

import java.util.regex.Matcher;

/**
 * Social Glutton (c) 2014
 * Created by mhontar on 04.07.14.
 */
public class BCDNamingStrategy implements INamingStrategy {
    @Override
    public String getFileName(MatcherWrapper mw) {
        final Matcher m = mw.getMatcher();
        return String.format("%s%s%s%03d", m.group(1), Constants.SPECIAL_SYMBOL_SEPARATOR_UNDERSCORE, Constants.SYMBOLIC_SEPARATOR_FIG, Integer.valueOf(m.group(3)));
    }

    @Override
    public String getThumbnailFileName(MatcherWrapper mw) {
        final Matcher m = mw.getMatcher();
        return String.format("%s%s%s%03d", m.group(1), Constants.SPECIAL_SYMBOL_SEPARATOR_UNDERSCORE, Constants.SYMBOLIC_SEPARATOR_FTH, Integer.valueOf(m.group(3)));
    }
}
