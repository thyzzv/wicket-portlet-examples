package org.apache.wicket.portlet.examples;

import org.apache.wicket.Application;
import org.apache.wicket.markup.head.CssHeaderItem;
import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.model.AbstractReadOnlyModel;
import org.apache.wicket.portlet.examples.guestbook.GuestBook;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.request.resource.CssResourceReference;

public class HomePage extends WicketPortletExamplePage
{
    public HomePage()
    {
     this(new PageParameters());
    }
    
    public HomePage(PageParameters params)
    {
     super(params);
     add(new Label("version", new AbstractReadOnlyModel<String>()
         {

           /**
            * 
            */
           private static final long serialVersionUID = 1L;

           @Override
           public String getObject()
           {

             /*
              * Read the specification version from the wicket-core MANIFEST.MF file.
              */
             Package p = Application.class.getPackage();

             String version = p.getSpecificationVersion();

             if (version == null || version.length() == 0)
             {
               return "Missing Version";
             }
             else
             {
               return version;
             }
           }
         }));
     
     add(new Link("ajax") {
       @Override
      public void onClick()
      {
        setResponsePage(org.apache.wicket.portlet.examples.ajax.builtin.Index.class);
      }
     });
     add(new Link("guestbook") {
       @Override
      public void onClick()
      {
        setResponsePage(GuestBook.class);
      }
     });
     add(new Link("compref") {
       @Override
      public void onClick()
      {
         setResponsePage(org.apache.wicket.portlet.examples.compref.Index.class);
      }
     });
    }
}
