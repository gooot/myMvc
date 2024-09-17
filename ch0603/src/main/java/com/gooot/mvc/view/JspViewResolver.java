package com.gooot.mvc.view;

import static com.gooot.mvc.view.RedirectView.*;

public class JspViewResolver implements ViewResolver {
	@Override
	public View resolverView(String viewName) {
		if (viewName.startsWith(DEFAULT_REDIRECT_PREFIX)) {
			return new RedirectView(viewName);
		}

		return new JspView(viewName + ".jsp");
	}

}

