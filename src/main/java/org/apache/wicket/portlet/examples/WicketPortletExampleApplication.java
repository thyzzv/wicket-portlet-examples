package org.apache.wicket.portlet.examples;

import java.util.ArrayList;
import java.util.List;

import org.apache.wicket.Page;
import org.apache.wicket.portlet.examples.ajax.builtin.AutoCompletePage;
import org.apache.wicket.portlet.examples.ajax.builtin.ChoicePage;
import org.apache.wicket.portlet.examples.ajax.builtin.ClockPage;
import org.apache.wicket.portlet.examples.ajax.builtin.EditableLabelPage;
import org.apache.wicket.portlet.examples.ajax.builtin.EffectsPage;
import org.apache.wicket.portlet.examples.ajax.builtin.FileUploadPage;
import org.apache.wicket.portlet.examples.ajax.builtin.FormPage;
import org.apache.wicket.portlet.examples.ajax.builtin.GuestBook;
import org.apache.wicket.portlet.examples.ajax.builtin.LazyLoadingPage;
import org.apache.wicket.portlet.examples.ajax.builtin.LinksPage;
import org.apache.wicket.portlet.examples.ajax.builtin.OnChangeAjaxBehaviorPage;
import org.apache.wicket.portlet.examples.ajax.builtin.PageablesPage;
import org.apache.wicket.portlet.examples.ajax.builtin.RatingsPage;
import org.apache.wicket.portlet.examples.ajax.builtin.TabbedPanelPage;
import org.apache.wicket.portlet.examples.ajax.builtin.TodoList;
import org.apache.wicket.portlet.examples.ajax.builtin.WorldClockPage;
import org.apache.wicket.portlet.examples.ajax.builtin.modal.ModalWindowPage;
import org.apache.wicket.portlet.examples.ajax.builtin.tree.EditableTreeTablePage;
import org.apache.wicket.portlet.examples.ajax.builtin.tree.SimpleTreePage;
import org.apache.wicket.portlet.examples.ajax.builtin.tree.TreeTablePage;
import org.apache.wicket.portlet.examples.compref.Person;
import org.apache.wicket.protocol.http.WebApplication;
import org.apache.wicket.response.filter.AjaxServerAndClientTimeFilter;
import org.apache.wicket.settings.ISecuritySettings;
import org.apache.wicket.util.crypt.ClassCryptFactory;
import org.apache.wicket.util.crypt.NoCrypt;

/**
 * Application object for your web application. If you want to run this
 * application without deploying, run the Start class.
 * 
 * @see wicket.myproject.Start#main(String[])
 */
public class WicketPortletExampleApplication extends WebApplication {
  /**
   * prevent wicket from launching a java application window on the desktop <br/>
   * once someone uses awt-specific classes java will automatically do so and allocate a window
   * unless you tell java to run in 'headless-mode'
   */
  static
  {
    System.setProperty("java.awt.headless", "true");
  }


  /**
   * Constructor.
   */
  public WicketPortletExampleApplication()
  {
  }

  /**
   * @see org.apache.wicket.protocol.http.WebApplication#init()
   */
  @Override
  protected void init()
  {
    // WARNING: DO NOT do this on a real world application unless
    // you really want your app's passwords all passed around and
    // stored in unencrypted browser cookies (BAD IDEA!)!!!

    // The NoCrypt class is being used here because not everyone
    // has the java security classes required by Crypt installed
    // and we want them to be able to run the examples out of the
    // box.
    getSecuritySettings().setCryptFactory(
      new ClassCryptFactory(NoCrypt.class, ISecuritySettings.DEFAULT_ENCRYPTION_KEY));

    getDebugSettings().setDevelopmentUtilitiesEnabled(true);
    
    getResourceSettings().setThrowExceptionOnMissingResource(false);

    getRequestCycleSettings().addResponseFilter(new AjaxServerAndClientTimeFilter());

    getDebugSettings().setAjaxDebugModeEnabled(true);

    mountPage("ajax/autocomplete", AutoCompletePage.class);
    mountPage("ajax/choice", ChoicePage.class);
    mountPage("ajax/clock", ClockPage.class);
    mountPage("ajax/editable-label", EditableLabelPage.class);
    mountPage("ajax/effects", EffectsPage.class);
    mountPage("ajax/form", FormPage.class);
    mountPage("ajax/guest-book", GuestBook.class);
    mountPage("ajax/lazy-loading", LazyLoadingPage.class);
    mountPage("ajax/links", LinksPage.class);
    mountPage("ajax/modal-window", ModalWindowPage.class);
    mountPage("ajax/on-change-ajax-behavior", OnChangeAjaxBehaviorPage.class);
    mountPage("ajax/pageables", PageablesPage.class);
    mountPage("ajax/ratings", RatingsPage.class);
    mountPage("ajax/tabbed-panel", TabbedPanelPage.class);
    mountPage("ajax/todo-list", TodoList.class);
    mountPage("ajax/world-clock", WorldClockPage.class);
    mountPage("ajax/tree/simple", SimpleTreePage.class);
    mountPage("ajax/tree/table", TreeTablePage.class);
    mountPage("ajax/tree/table/editable", EditableTreeTablePage.class);
    mountPage("ajax/upload", FileUploadPage.class);
    mountPage("guestbook/guest", GuestBook.class);
  }

  @Override
  public Class<? extends Page> getHomePage()
  {
    return HomePage.class;        
  }
  
  
  private static final List<Person> personsDB;
  static
  {
    personsDB = new ArrayList<Person>();
    personsDB.add(new Person("Fritz", "Fritzel"));
    personsDB.add(new Person("Ghan", "Phariounimn"));
    personsDB.add(new Person("Jan", "Klaasen"));
    personsDB.add(new Person("Hank", "Plaindweller"));
  }

  /**
   * @return persons db
   */
  public static final List<Person> getPersons()
  {
    return personsDB;
  }

}
