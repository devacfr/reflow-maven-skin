/*
 * Copyright 2012-2019 Christophe Friederich
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.devacfr.testing;

import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.ArgumentMatcher;
import org.mockito.InOrder;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.MockSettings;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.mockito.stubbing.Answer;
import org.mockito.stubbing.DeprecatedOngoingStubbing;
import org.mockito.stubbing.OngoingStubbing;
import org.mockito.stubbing.Stubber;
import org.mockito.verification.VerificationMode;
import org.mockito.verification.VerificationWithTimeout;

/**
 * <p>
 * This class allow to migrate form JUnit 3.x syntax to JUnit 4.
 * </p>
 * it is also Mock facility.
 *
 * @author Christophe Friederich
 */
@RunWith(MockitoJUnitRunner.class)
public abstract class MockitoTestCase extends TestCase {

    /**
     *
     */
    public MockitoTestCase() {

    }

    /**
     * any object or null.
     * <p>
     * Shorter alias to {@link Matchers#anyObject()}
     * <p>
     * See examples in javadoc for {@link Matchers} class
     *
     * @return <code>null</code>.
     */
    @SuppressWarnings("unchecked")
    protected static <T> T any() {
        return (T) Matchers.any();
    }

    /**
     * Object argument that is equal to the given value.
     * <p>
     * See examples in javadoc for {@link Matchers} class
     *
     * @param value
     *            the given value.
     * @return <code>null</code>.
     */
    protected static <T> T eq(final T cl) {
        return Matchers.eq(cl);
    }

    /**
     * any object or null.
     * <p>
     * Shorter alias to {@link Matchers#anyObject()}
     * <p>
     * See examples in javadoc for {@link Matchers} class
     *
     * @return <code>null</code>.
     */
    protected static <T> T any(final Class<T> cl) {
        return Matchers.any(cl);
    }

    /**
     * Creates mock object of given class or interface.
     * <p>
     * See examples in javadoc for {@link Mockito} class
     *
     * @param classToMock
     *            class or interface to mock
     * @return mock object
     */
    protected static <T> T mock(final Class<T> classToMock) {
        return Mockito.mock(classToMock);
    }

    /**
     * Specifies mock name. Naming mocks can be helpful for debugging - the name is used in all verification errors.
     * <p>
     * Beware that naming mocks is not a solution for complex code which uses too many mocks or collaborators. <b>If you
     * have too many mocks then refactor the code</b> so that it's easy to test/debug without necessity of naming mocks.
     * <p>
     * <b>If you use &#064;Mock annotation then you've got naming mocks for free!</b> &#064;Mock uses field name as mock
     * name. {@link Mock Read more.}
     * <p>
     * See examples in javadoc for {@link Mockito} class
     *
     * @param classToMock
     *            class or interface to mock
     * @param name
     *            of the mock
     * @return mock object
     */
    protected static <T> T mock(final Class<T> classToMock, final String name) {
        return Mockito.mock(classToMock, name);
    }

    /**
     * Creates mock with a specified strategy for its answers to interactions. It's quite advanced feature and typically
     * you don't need it to write decent tests. However it can be helpful when working with legacy systems.
     * <p>
     * It is the default answer so it will be used <b>only when you don't</b> stub the method call.
     *
     * <pre>
     *
     * Foo mock = mock(Foo.class, RETURNS_SMART_NULLS);
     *
     * Foo mockTwo = mock(Foo.class, new YourOwnAnswer());
     * </pre>
     * <p>
     * See examples in javadoc for {@link Mockito} class
     * </p>
     *
     * @param classToMock
     *            class or interface to mock
     * @param defaultAnswer
     *            default answer for unstubbed methods
     * @return mock object
     */
    protected static <T> T mock(final Class<T> classToMock, final Answer<?> defaultAnswer) {
        return Mockito.mock(classToMock, defaultAnswer);
    }

    /**
     * Creates a mock with some non-standard settings.
     * <p>
     * The number of configuration points for a mock grows so we need a fluent way to introduce new configuration
     * without adding more and more overloaded Mockito.mock() methods. Hence {@link MockSettings}.
     *
     * <pre>
     *   Listener mock = mock(Listener.class, withSettings()
     *     .name("firstListner").defaultBehavior(RETURNS_SMART_NULLS));
     *   );
     * </pre>
     *
     * <b>Use it carefully and occasionally</b>. What might be reason your test needs non-standard mocks? Is the code
     * under test so complicated that it requires non-standard mocks? Wouldn't you prefer to refactor the code under
     * test so it is testable in a simple way?
     * <p>
     * See also {@link Mockito#withSettings()}
     * <p>
     * See examples in javadoc for {@link Mockito} class
     *
     * @param classToMock
     *            class or interface to mock
     * @param mockSettings
     *            additional mock settings
     * @return mock object
     */
    protected static <T> T mock(final Class<T> classToMock, final MockSettings mockSettings) {
        return Mockito.mock(classToMock, mockSettings);
    }

    /**
     * Creates a spy of the real object. The spy calls <b>real</b> methods unless they are stubbed.
     * <p>
     * Real spies should be used <b>carefully and occasionally</b>, for example when dealing with legacy code.
     * <p>
     * As usual you are going to read <b>the partial mock warning</b>: Object oriented programming is more less tackling
     * complexity by dividing the complexity into separate, specific, SRPy objects. How does partial mock fit into this
     * paradigm? Well, it just doesn't... Partial mock usually means that the complexity has been moved to a different
     * method on the same object. In most cases, this is not the way you want to design your application.
     * <p>
     * However, there are rare cases when partial mocks come handy: dealing with code you cannot change easily (3rd
     * party interfaces, interim refactoring of legacy code etc.) However, I wouldn't use partial mocks for new,
     * test-driven & well-designed code.
     * <p>
     * Example:
     *
     * <pre>
     * List list = new LinkedList();
     * List spy = spy(list);
     *
     * // optionally, you can stub out some methods:
     * when(spy.size()).thenReturn(100);
     *
     * // using the spy calls &lt;b&gt;real&lt;/b&gt; methods
     * spy.add(&quot;one&quot;);
     * spy.add(&quot;two&quot;);
     *
     * // prints &quot;one&quot; - the first element of a list
     * System.out.println(spy.get(0));
     *
     * // size() method was stubbed - 100 is printed
     * System.out.println(spy.size());
     *
     * // optionally, you can verify
     * verify(spy).add(&quot;one&quot;);
     * verify(spy).add(&quot;two&quot;);
     * </pre>
     *
     * <h4>Important gotcha on spying real objects!</h4> 1. Sometimes it's impossible to use
     * {@link Mockito#when(Object)} for stubbing spies. Example:
     *
     * <pre>
     * List list = new LinkedList();
     * List spy = spy(list);
     *
     * // Impossible: real method is called so spy.get(0) throws IndexOutOfBoundsException (the list is yet empty)
     * when(spy.get(0)).thenReturn(&quot;foo&quot;);
     *
     * // You have to use doReturn() for stubbing
     * doReturn(&quot;foo&quot;).when(spy).get(0);
     * </pre>
     *
     * 2. Watch out for final methods. Mockito doesn't mock final methods so the bottom line is: when you spy on real
     * objects + you try to stub a final method = trouble. What will happen is the real method will be called *on mock*
     * but *not on the real instance* you passed to the spy() method. Typically you may get a NullPointerException
     * because mock instances don't have fields initiated.
     * <p>
     * See examples in javadoc for {@link Mockito} class
     *
     * @param object
     *            to spy on
     * @return a spy of the real object
     */
    protected static <T> T spy(final T object) {
        return Mockito.spy(object);
    }

    /**
     * Stubs a method call with return value or an exception. E.g:
     *
     * <pre>
     * stub(mock.someMethod()).toReturn(10);
     *
     * //you can use flexible argument matchers, e.g:
     * stub(mock.someMethod(<b>anyString()</b>)).toReturn(10);
     *
     * //setting exception to be thrown:
     * stub(mock.someMethod("some arg")).toThrow(new RuntimeException());
     *
     * //you can stub with different behavior for consecutive method calls.
     * //Last stubbing (e.g: toReturn("foo")) determines the behavior for further consecutive calls.
     * stub(mock.someMethod("some arg"))
     *  .toThrow(new RuntimeException())
     *  .toReturn("foo");
     * </pre>
     * <p>
     * Some users find stub() confusing therefore {@link Mockito#when(Object)} is recommended over stub()
     *
     * <pre>
     * // Instead of:
     * stub(mock.count()).toReturn(10);
     *
     * // You can do:
     * when(mock.count()).thenReturn(10);
     * </pre>
     *
     * For stubbing void methods with throwables see: {@link Mockito#doThrow(Throwable)}
     * <p>
     * Stubbing can be overridden: for example common stubbing can go to fixture setup but the test methods can override
     * it. Please note that overridding stubbing is a potential code smell that points out too much stubbing.
     * <p>
     * Once stubbed, the method will always return stubbed value regardless of how many times it is called.
     * <p>
     * Last stubbing is more important - when you stubbed the same method with the same arguments many times.
     * <p>
     * Although it is possible to verify a stubbed invocation, usually <b>it's just redundant</b>. Let's say you've
     * stubbed foo.bar(). If your code cares what foo.bar() returns then something else breaks(often before even
     * verify() gets executed). If your code doesn't care what get(0) returns then it should not be stubbed. Not
     * convinced? See <a href="http://monkeyisland.pl/2008/04/26/asking-and-telling">here</a>.
     *
     * @param methodCall
     *            method call
     * @return DeprecatedOngoingStubbing object to set stubbed value/exception
     */
    protected static <T> DeprecatedOngoingStubbing<T> stub(final T methodCall) {
        return Mockito.stub(methodCall);
    }

    /**
     * Enables stubbing methods. Use it when you want the mock to return particular value when particular method is
     * called.
     * <p>
     * Simply put: "<b>When</b> the x method is called <b>then</b> return y".
     * <p>
     * <b>when() is a successor of deprecated {@link Mockito#stub(Object)}</b>
     * <p>
     * Examples:
     *
     * <pre>
     * <b>when</b>(mock.someMethod()).<b>thenReturn</b>(10);
     *
     * //you can use flexible argument matchers, e.g:
     * when(mock.someMethod(<b>anyString()</b>)).thenReturn(10);
     *
     * //setting exception to be thrown:
     * when(mock.someMethod("some arg")).thenThrow(new RuntimeException());
     *
     * //you can set different behavior for consecutive method calls.
     * //Last stubbing (e.g: thenReturn("foo")) determines the behavior of further consecutive calls.
     * when(mock.someMethod("some arg"))
     *  .thenThrow(new RuntimeException())
     *  .thenReturn("foo");
     *
     * //Alternative, shorter version for consecutive stubbing:
     * when(mock.someMethod("some arg"))
     *  .thenReturn("one", "two");
     * //is the same as:
     * when(mock.someMethod("some arg"))
     *  .thenReturn("one")
     *  .thenReturn("two");
     *
     * //shorter version for consecutive method calls throwing exceptions:
     * when(mock.someMethod("some arg"))
     *  .thenThrow(new RuntimeException(), new NullPointerException();
     * </pre>
     *
     * For stubbing void methods with throwables see: {@link Mockito#doThrow(Throwable)}
     * <p>
     * Stubbing can be overridden: for example common stubbing can go to fixture setup but the test methods can override
     * it. Please note that overridding stubbing is a potential code smell that points out too much stubbing.
     * <p>
     * Once stubbed, the method will always return stubbed value regardless of how many times it is called.
     * <p>
     * Last stubbing is more important - when you stubbed the same method with the same arguments many times.
     * <p>
     * Although it is possible to verify a stubbed invocation, usually <b>it's just redundant</b>. Let's say you've
     * stubbed foo.bar(). If your code cares what foo.bar() returns then something else breaks(often before even
     * verify() gets executed). If your code doesn't care what get(0) returns then it should not be stubbed. Not
     * convinced? See <a href="http://monkeyisland.pl/2008/04/26/asking-and-telling">here</a>.
     * <p>
     * See examples in javadoc for {@link Mockito} class
     *
     * @param methodCall
     *            method to be stubbed
     */
    protected static <T> OngoingStubbing<T> when(final T methodCall) {
        return Mockito.when(methodCall);
    }

    /**
     * Verifies certain behavior <b>happened once</b>
     * <p>
     * Alias to <code>verify(mock, times(1))</code> E.g:
     *
     * <pre>
     * verify(mock).someMethod(&quot;some arg&quot;);
     * </pre>
     *
     * Above is equivalent to:
     *
     * <pre>
     * verify(mock, times(1)).someMethod(&quot;some arg&quot;);
     * </pre>
     * <p>
     * Arguments passed are compared using equals() method. Read about {@link ArgumentCaptor} or {@link ArgumentMatcher}
     * to find out other ways of matching / asserting arguments passed.
     * <p>
     * Although it is possible to verify a stubbed invocation, usually <b>it's just redundant</b>. Let's say you've
     * stubbed foo.bar(). If your code cares what foo.bar() returns then something else breaks(often before even
     * verify() gets executed). If your code doesn't care what get(0) returns then it should not be stubbed. Not
     * convinced? See <a href="http://monkeyisland.pl/2008/04/26/asking-and-telling">here</a>.
     * <p>
     * See examples in javadoc for {@link Mockito} class
     *
     * @param mock
     *            to be verified
     * @return mock object itself
     */
    protected static <T> T verify(final T mock) {
        return Mockito.verify(mock);
    }

    /**
     * Verifies certain behavior happened at least once / exact number of times / never. E.g:
     *
     * <pre>
     *   verify(mock, times(5)).someMethod("was called five times");
     *
     *   verify(mock, atLeast(2)).someMethod("was called at least two times");
     *
     *   //you can use flexible argument matchers, e.g:
     *   verify(mock, atLeastOnce()).someMethod(<b>anyString()</b>);
     * </pre>
     *
     * <b>times(1) is the default</b> and can be omitted
     * <p>
     * Arguments passed are compared using equals() method. Read about {@link ArgumentCaptor} or {@link ArgumentMatcher}
     * to find out other ways of matching / asserting arguments passed.
     * <p>
     *
     * @param mock
     *            to be verified
     * @param mode
     *            times(x), atLeastOnce() or never()
     * @return mock object itself
     */
    protected static <T> T verify(final T mock, final VerificationMode mode) {
        return Mockito.verify(mock, mode);
    }

    /**
     * Smart Mockito users hardly use this feature because they know it could be a sign of poor tests. Normally, you
     * don't need to reset your mocks, just create new mocks for each test method.
     * <p>
     * Instead of reset() please consider writing simple, small and focused test methods over lengthy, over-specified
     * tests. <b>First potential code smell is reset() in the middle of the test method.</b> This probably means you're
     * testing too much. Follow the whisper of your test methods: "Please keep us small & focused on single behavior".
     * There are several threads about it on mockito mailing list.
     * <p>
     * The only reason we added reset() method is to make it possible to work with container-injected mocks. See issue
     * 55 (<a href="http://code.google.com/p/mockito/issues/detail?id=55">here</a>) or FAQ (
     * <a href="http://code.google.com/p/mockito/wiki/FAQ">here</a>).
     * <p>
     * <b>Don't harm yourself.</b> reset() in the middle of the test method is a code smell (you're probably testing too
     * much).
     *
     * <pre>
     * List mock = mock(List.class);
     * when(mock.size()).thenReturn(10);
     * mock.add(1);
     *
     * reset(mock);
     * // at this point the mock forgot any interactions &amp; stubbing
     * </pre>
     *
     * @param <T>
     * @param mocks
     *            to be reset
     */
    @SuppressWarnings("unchecked")
    protected static <T> void reset(final T... mocks) {
        Mockito.reset(mocks);
    }

    /**
     * Checks if any of given mocks has any unverified interaction.
     * <p>
     * You can use this method after you verified your mocks - to make sure that nothing else was invoked on your mocks.
     * <p>
     * See also {@link Mockito#never()} - it is more explicit and communicates the intent well.
     * <p>
     * Stubbed invocations (if called) are also treated as interactions.
     * <p>
     * A word of <b>warning</b>: Some users who did a lot of classic, expect-run-verify mocking tend to use
     * verifyNoMoreInteractions() very often, even in every test method. verifyNoMoreInteractions() is not recommended
     * to use in every test method. verifyNoMoreInteractions() is a handy assertion from the interaction testing
     * toolkit. Use it only when it's relevant. Abusing it leads to overspecified, less maintainable tests. You can find
     * further reading <a href="http://monkeyisland.pl/2008/07/12/should-i-worry-about-the-unexpected/">here</a>.
     * <p>
     * This method will also detect unverified invocations that occurred before the test method, for example: in
     * setUp(), &#064;Before method or in constructor. Consider writing nice code that makes interactions only in test
     * methods.
     * <p>
     * Example:
     *
     * <pre>
     * // interactions
     * mock.doSomething();
     * mock.doSomethingUnexpected();
     *
     * // verification
     * verify(mock).doSomething();
     *
     * // following will fail because 'doSomethingUnexpected()' is unexpected
     * verifyNoMoreInteractions(mock);
     *
     * </pre>
     *
     * See examples in javadoc for {@link Mockito} class
     *
     * @param mocks
     *            to be verified
     */
    protected static void verifyNoMoreInteractions(final Object... mocks) {
        Mockito.verifyNoMoreInteractions(mocks);
    }

    /**
     * Verifies that no interactions happened on given mocks.
     *
     * <pre>
     * verifyZeroInteractions(mockOne, mockTwo);
     * </pre>
     *
     * This method will also detect invocations that occurred before the test method, for example: in setUp(),
     * &#064;Before method or in constructor. Consider writing nice code that makes interactions only in test methods.
     * <p>
     * See also {@link Mockito#never()} - it is more explicit and communicates the intent well.
     * <p>
     * See examples in javadoc for {@link Mockito} class
     *
     * @param mocks
     *            to be verified
     */
    protected void verifyZeroInteractions(final Object... mocks) {
        Mockito.verifyZeroInteractions(mocks);
    }

    /**
     * Use doThrow() when you want to stub the void method with an exception.
     * <p>
     * Stubbing voids requires different approach from {@link Mockito#when(Object)} because the compiler does not like
     * void methods inside brackets...
     * <p>
     * Example:
     *
     * <pre>
     * doThrow(new RuntimeException()).when(mock).someVoidMethod();
     * </pre>
     *
     * @param toBeThrown
     *            to be thrown when the stubbed method is called
     * @return stubber - to select a method for stubbing
     */
    protected Stubber doThrow(final Throwable toBeThrown) {
        return Mockito.doThrow(toBeThrown);
    }

    /**
     * Use <code>doThrow()</code> when you want to stub the void method to throw exception of specified class.
     * <p>
     * A new exception instance will be created for each method invocation.
     * <p>
     * Stubbing voids requires different approach from {@link Mockito#when(Object)} because the compiler does not like
     * void methods inside brackets...
     * <p>
     * Example:
     *
     * <pre class="code">
     * <code class="java">
     *   doThrow(RuntimeException.class).when(mock).someVoidMethod();
     * </code>
     * </pre>
     *
     * @param toBeThrown
     *            to be thrown when the stubbed method is called
     * @return stubber - to select a method for stubbing
     */
    public static Stubber doThrow(final Class<? extends Throwable> toBeThrown) {
        return Mockito.doThrow(toBeThrown);
    }

    /**
     * Use doCallRealMethod() when you want to call the real implementation of a method.
     * <p>
     * As usual you are going to read <b>the partial mock warning</b>: Object oriented programming is more less tackling
     * complexity by dividing the complexity into separate, specific, SRPy objects. How does partial mock fit into this
     * paradigm? Well, it just doesn't... Partial mock usually means that the complexity has been moved to a different
     * method on the same object. In most cases, this is not the way you want to design your application.
     * <p>
     * However, there are rare cases when partial mocks come handy: dealing with code you cannot change easily (3rd
     * party interfaces, interim refactoring of legacy code etc.) However, I wouldn't use partial mocks for new,
     * test-driven & well-designed code.
     * <p>
     * See also javadoc {@link Mockito#spy(Object)} to find out more about partial mocks. <b>Mockito.spy() is a
     * recommended way of creating partial mocks.</b> The reason is it guarantees real methods are called against
     * correctly constructed object because you're responsible for constructing the object passed to spy() method.
     * <p>
     * Example:
     *
     * <pre>
     * Foo mock = mock(Foo.class);
     * doCallRealMethod().when(mock).someVoidMethod();
     *
     * // this will call the real implementation of Foo.someVoidMethod()
     * mock.someVoidMethod();
     * </pre>
     * <p>
     * See examples in javadoc for {@link Mockito} class
     *
     * @return stubber - to select a method for stubbing
     */
    protected static Stubber doCallRealMethod() {
        return Mockito.doCallRealMethod();
    }

    /**
     * Use doAnswer() when you want to stub a void method with generic {@link Answer}.
     * <p>
     * Stubbing voids requires different approach from {@link Mockito#when(Object)} because the compiler does not like
     * void methods inside brackets...
     * <p>
     * Example:
     *
     * <pre>
     * doAnswer(new Answer() {
     *
     *     public Object answer(InvocationOnMock invocation) {
     *         Object[] args = invocation.getArguments();
     *         Mock mock = invocation.getMock();
     *         return null;
     *     }
     * }).when(mock).someMethod();
     * </pre>
     * <p>
     * See examples in javadoc for {@link Mockito} class
     *
     * @param answer
     *            to answer when the stubbed method is called
     * @return stubber - to select a method for stubbing
     */
    protected static Stubber doAnswer(final Answer<?> answer) {
        return Mockito.doAnswer(answer);
    }

    /**
     * Use doNothing() for setting void methods to do nothing. <b>Beware that void methods on mocks do nothing by
     * default!</b> However, there are rare situations when doNothing() comes handy:
     * <p>
     * 1. Stubbing consecutive calls on a void method:
     *
     * <pre>
     * doNothing().doThrow(new RuntimeException()).when(mock).someVoidMethod();
     *
     * // does nothing the first time:
     * mock.someVoidMethod();
     *
     * // throws RuntimeException the next time:
     * mock.someVoidMethod();
     * </pre>
     *
     * 2. When you spy real objects and you want the void method to do nothing:
     *
     * <pre>
     * List list = new LinkedList();
     * List spy = spy(list);
     *
     * // let's make clear() do nothing
     * doNothing().when(spy).clear();
     *
     * spy.add(&quot;one&quot;);
     *
     * // clear() does nothing, so the list still contains &quot;one&quot;
     * spy.clear();
     * </pre>
     * <p>
     * See examples in javadoc for {@link Mockito} class
     *
     * @return stubber - to select a method for stubbing
     */
    protected static Stubber doNothing() {
        return Mockito.doNothing();
    }

    /**
     * Use doReturn() in those rare occasions when you cannot use {@link Mockito#when(Object)}.
     * <p>
     * <b>Beware that {@link Mockito#when(Object)} is always recommended for stubbing because it is argument type-safe
     * and more readable</b> (especially when stubbing consecutive calls).
     * <p>
     * Here are those rare occasions when doReturn() comes handy:
     * <p>
     * 1. When spying real objects and calling real methods on a spy brings side effects
     *
     * <pre>
     * List list = new LinkedList();
     * List spy = spy(list);
     *
     * // Impossible: real method is called so spy.get(0) throws IndexOutOfBoundsException (the list is yet empty)
     * when(spy.get(0)).thenReturn(&quot;foo&quot;);
     *
     * // You have to use doReturn() for stubbing:
     * doReturn(&quot;foo&quot;).when(spy).get(0);
     * </pre>
     *
     * 2. Overriding a previous exception-stubbing:
     *
     * <pre>
     * when(mock.foo()).thenThrow(new RuntimeException());
     *
     * // Impossible: the exception-stubbed foo() method is called so RuntimeException is thrown.
     * when(mock.foo()).thenReturn(&quot;bar&quot;);
     *
     * // You have to use doReturn() for stubbing:
     * doReturn(&quot;bar&quot;).when(mock).foo();
     * </pre>
     *
     * Above scenarios shows a tradeoff of Mockito's ellegant syntax. Note that the scenarios are very rare, though.
     * Spying should be sporadic and overriding exception-stubbing is very rare. Not to mention that in general
     * overridding stubbing is a potential code smell that points out too much stubbing.
     * <p>
     * See examples in javadoc for {@link Mockito} class
     *
     * @param toBeReturned
     *            to be returned when the stubbed method is called
     * @return stubber - to select a method for stubbing
     */
    protected static Stubber doReturn(final Object toBeReturned) {
        return Mockito.doReturn(toBeReturned);
    }

    /**
     * Creates InOrder object that allows verifying mocks in order.
     *
     * <pre>
     * InOrder inOrder = inOrder(firstMock, secondMock);
     *
     * inOrder.verify(firstMock).add(&quot;was called first&quot;);
     * inOrder.verify(secondMock).add(&quot;was called second&quot;);
     * </pre>
     *
     * Verification in order is flexible - <b>you don't have to verify all interactions</b> one-by-one but only those
     * that you are interested in testing in order.
     * <p>
     * Also, you can create InOrder object passing only mocks that are relevant for in-order verification.
     * <p>
     * InOrder verification is 'greedy'. You will hardly every notice it but if you want to find out more search for
     * 'greedy' on the Mockito <a href="http://code.google.com/p/mockito/w/list">wiki pages</a>.
     * <p>
     * As of Mockito 1.8.4 you can verifyNoMoreInvocations() in order-sensitive way. Read more:
     * {@link InOrder#verifyNoMoreInteractions()}
     * <p>
     * See examples in javadoc for {@link Mockito} class
     *
     * @param mocks
     *            to be verified in order
     * @return InOrder object to be used to verify in order
     */
    protected static InOrder inOrder(final Object... mocks) {
        return Mockito.inOrder(mocks);
    }

    /**
     * Allows verifying exact number of invocations. E.g:
     *
     * <pre>
     * verify(mock, times(2)).someMethod(&quot;some arg&quot;);
     * </pre>
     *
     * See examples in javadoc for {@link Mockito} class
     *
     * @param wantedNumberOfInvocations
     *            wanted number of invocations
     * @return verification mode
     */
    protected VerificationMode times(final int wantedNumberOfInvocations) {
        return Mockito.times(wantedNumberOfInvocations);
    }

    /**
     * Alias to times(0), see {@link Mockito#times(int)}
     * <p>
     * Verifies that interaction did not happen. E.g:
     *
     * <pre>
     * verify(mock, never()).someMethod();
     * </pre>
     * <p>
     * If you want to verify there were NO interactions with the mock check out
     * {@link Mockito#verifyZeroInteractions(Object...)} or {@link Mockito#verifyNoMoreInteractions(Object...)}
     * <p>
     * See examples in javadoc for {@link Mockito} class
     *
     * @return verification mode
     */
    protected VerificationMode never() {
        return Mockito.never();
    }

    /**
     * Allows at-least-once verification. E.g:
     *
     * <pre>
     * verify(mock, atLeastOnce()).someMethod(&quot;some arg&quot;);
     * </pre>
     *
     * Alias to atLeast(1)
     * <p>
     * See examples in javadoc for {@link Mockito} class
     *
     * @return verification mode
     */
    protected VerificationMode atLeastOnce() {
        return Mockito.atLeastOnce();
    }

    /**
     * Allows at-least-x verification. E.g:
     *
     * <pre>
     * verify(mock, atLeast(3)).someMethod(&quot;some arg&quot;);
     * </pre>
     *
     * See examples in javadoc for {@link Mockito} class
     *
     * @param minNumberOfInvocations
     *            minimum number of invocations
     * @return verification mode
     */
    protected static VerificationMode atLeast(final int minNumberOfInvocations) {
        return Mockito.atLeast(minNumberOfInvocations);
    }

    /**
     * Allows at-most-x verification. E.g:
     *
     * <pre>
     * verify(mock, atMost(3)).someMethod(&quot;some arg&quot;);
     * </pre>
     *
     * See examples in javadoc for {@link Mockito} class
     *
     * @param maxNumberOfInvocations
     *            max number of invocations
     * @return verification mode
     */
    protected static VerificationMode atMost(final int maxNumberOfInvocations) {
        return Mockito.atMost(maxNumberOfInvocations);
    }

    /**
     * Allows checking if given method was the only one invoked. E.g:
     *
     * <pre>
     * verify(mock, only()).someMethod();
     * // above is a shorthand for following 2 lines of code:
     * verify(mock).someMethod();
     * verifyNoMoreInvocations(mock);
     * </pre>
     * <p>
     * See also {@link Mockito#verifyNoMoreInteractions(Object...)}
     * <p>
     * See examples in javadoc for {@link Mockito} class
     *
     * @return verification mode
     */
    protected static VerificationMode only() {
        return Mockito.only();
    }

    /**
     * Allows verifying with timeout. May be useful for testing in concurrent conditions.
     * <p>
     * It feels this feature should be used rarely - figure out a better way of testing your multi-threaded system
     * <p>
     * Not yet implemented to work with InOrder verification.
     *
     * <pre>
     * // passes when someMethod() is called within given time span
     * verify(mock, timeout(100)).someMethod();
     * // above is an alias to:
     * verify(mock, timeout(100).times(1)).someMethod();
     *
     * // passes when someMethod() is called *exactly* 2 times within given time span
     * verify(mock, timeout(100).times(2)).someMethod();
     *
     * // passes when someMethod() is called *at lest* 2 times within given time span
     * verify(mock, timeout(100).atLeast(2)).someMethod();
     *
     * // verifies someMethod() within given time span using given verification mode
     * // useful only if you have your own custom verification modes.
     * verify(mock, new Timeout(100, yourOwnVerificationMode)).someMethod();
     * </pre>
     *
     * See examples in javadoc for {@link Mockito} class
     *
     * @param millis
     *            - time span in millis
     * @return verification mode
     */
    protected static VerificationWithTimeout timeout(final int millis) {
        return Mockito.timeout(millis);
    }

    /**
     * First of all, in case of any trouble, I encourage you to read the Mockito FAQ:
     * <a href="http://code.google.com/p/mockito/wiki/FAQ">http://code.google.com/p/mockito/wiki/FAQ</a>
     * <p>
     * In case of questions you may also post to mockito mailing list:
     * <a href="http://groups.google.com/group/mockito">http://groups.google.com/group/mockito</a>
     * <p>
     * validateMockitoUsage() <b>explicitly validates</b> the framework state to detect invalid use of Mockito. However,
     * this feature is optional <b>because Mockito validates the usage all the time...</b> but there is a gotcha so read
     * on.
     * <p>
     * Examples of incorrect use:
     *
     * <pre>
     * // Oups, someone forgot thenReturn() part:
     * when(mock.get());
     *
     * // Oups, someone put the verified method call inside verify() where it should be outside:
     * verify(mock.execute());
     *
     * // Oups, someone has used EasyMock for too long and forgot to specify the method to verify:
     * verify(mock);
     * </pre>
     *
     * Mockito throws exceptions if you misuse it so that you know if your tests are written correctly. The gotcha is
     * that Mockito does the validation <b>next time</b> you use the framework (e.g. next time you verify, stub, call
     * mock etc.). But even though the exception might be thrown in the next test, the exception <b>message contains a
     * navigable stack trace element</b> with location of the defect. Hence you can click and find the place where
     * Mockito was misused.
     * <p>
     * Sometimes though, you might want to validate the framework usage explicitly. For example, one of the users wanted
     * to put validateMockitoUsage() in his &#064;After method so that he knows immediately when he misused Mockito.
     * Without it, he would have known about it not sooner than <b>next time</b> he used the framework. One more benefit
     * of having validateMockitoUsage() in &#064;After is that jUnit runner will always fail in the test method with
     * defect whereas ordinary 'next-time' validation might fail the <b>next</b> test method. But even though JUnit
     * might report next test as red, don't worry about it and just click at navigable stack trace element in the
     * exception message to instantly locate the place where you misused mockito.
     * <p>
     * <b>Built-in runner: {@link MockitoJUnitRunner}</b> does validateMockitoUsage() after each test method.
     * <p>
     * Bear in mind that <b>usually you don't have to validateMockitoUsage()</b> and framework validation triggered on
     * next-time basis should be just enough, mainly because of enhanced exception message with clickable location of
     * defect. However, I would recommend validateMockitoUsage() if you already have sufficient test infrastructure
     * (like your own runner or base class for all tests) because adding a special action to &#064;After has zero cost.
     * <p>
     * See examples in javadoc for {@link Mockito} class
     */
    protected static void validateMockitoUsage() {
        Mockito.validateMockitoUsage();
    }

    /**
     * Allows mock creation with additional mock settings.
     * <p>
     * Don't use it too often. Consider writing simple tests that use simple mocks. Repeat after me: simple tests push
     * simple, KISSy, readable & maintainable code. If you cannot write a test in a simple way - refactor the code under
     * test.
     * <p>
     * Examples of mock settings:
     *
     * <pre>
     *
     * // Creates mock with different default answer &amp; name
     * Foo mock = mock(Foo.class, withSettings().defaultAnswer(RETURNS_SMART_NULLS).name(&quot;cool mockie&quot;));
     *
     * // Creates mock with different default answer, descriptive name and extra interfaces
     * Foo mock = mock(Foo.class,
     *     withSettings().defaultAnswer(RETURNS_SMART_NULLS).name(&quot;cool mockie&quot;).extraInterfaces(Bar.class));
     * </pre>
     *
     * {@link MockSettings} has been introduced for two reasons. Firstly, to make it easy to add another mock settings
     * when the demand comes. Secondly, to enable combining different mock settings without introducing zillions of
     * overloaded mock() methods.
     * <p>
     * See javadoc for {@link MockSettings} to learn about possible mock settings.
     * <p>
     *
     * @return mock settings instance with defaults.
     */
    protected static MockSettings withSettings() {
        return Mockito.withSettings();
    }

}
