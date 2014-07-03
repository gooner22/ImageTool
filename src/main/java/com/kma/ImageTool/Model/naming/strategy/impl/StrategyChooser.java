package com.kma.ImageTool.Model.naming.strategy.impl;

import com.kma.ImageTool.Model.naming.Constants;
import com.kma.ImageTool.Model.naming.MatcherWrapper;
import com.kma.ImageTool.Model.naming.strategy.INamingStrategy;

/**
 * Social Glutton (c) 2014
 * Created by mhontar on 04.07.14.
 */
public class StrategyChooser implements INamingStrategy{

    private INamingStrategy chooseStrategy(MatcherWrapper mw){
        final String regex = mw.getRegex();
        if (regex.equals(Constants.REGEX_GENERAL)){
            return new GeneralNamingStrategy();
        }else if(regex.equals(Constants.REGEX_BCD)){
            return new BCDNamingStrategy();
        }
        return new GeneralNamingStrategy();
    }

    @Override
    public String getFileName(MatcherWrapper mw) {
        return chooseStrategy(mw).getFileName(mw);
    }

    @Override
    public String getThumbnailFileName(MatcherWrapper mw) {
        return chooseStrategy(mw).getThumbnailFileName(mw);
    }
}
