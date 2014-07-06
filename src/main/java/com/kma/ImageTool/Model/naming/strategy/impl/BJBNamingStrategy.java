package com.kma.ImageTool.Model.naming.strategy.impl;

import com.kma.ImageTool.Model.naming.Constants;
import com.kma.ImageTool.Model.naming.MatcherWrapper;
import com.kma.ImageTool.Model.naming.strategy.INamingStrategy;

import java.util.regex.Matcher;

/**
 * Social Glutton (c) 2014
 * Created by mhontar on 04.07.14.
 */
public class BJBNamingStrategy implements INamingStrategy {
    @Override
    public String getFileName(MatcherWrapper mw) {
        final Matcher m = mw.getMatcher();
        return String.format("%s%s%s", m.group(2), Constants.SYMBOLIC_SEPARATOR, m.group(3));
    }

    @Override
    public String getThumbnailFileName(MatcherWrapper mw) {
        return String.format("%s%s",getFileName(mw), Constants.THUMBNAIL_SUFFIX);
    }

    @Override
    public int getNumberOfFile(MatcherWrapper mw) {
        return Integer.valueOf(mw.getMatcher().group(3));
    }
}
