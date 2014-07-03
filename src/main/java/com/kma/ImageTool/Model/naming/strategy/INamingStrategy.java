package com.kma.ImageTool.Model.naming.strategy;

import com.kma.ImageTool.Model.naming.MatcherWrapper;

/**
 * Social Glutton (c) 2014
 * Created by mhontar on 04.07.14.
 */
public interface INamingStrategy {
    public String getFileName(MatcherWrapper mw);
    public String getThumbnailFileName(MatcherWrapper mw);
}
