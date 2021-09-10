/*
 * Copyright 2002-2021 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.core.type;

/**
 * 方法的元数据类。提供获取方法名称、此方法所属类的全类名、是否是抽象方法、判断是否是静态方法、判断是否是final方法等。
 * <p>
 * Interface that defines abstract access to the annotations of a specific
 * method, in a form that does not require that method's class to be loaded yet.
 *
 * @author Juergen Hoeller
 * @author Mark Pollack
 * @author Chris Beams
 * @author Phillip Webb
 * @see StandardMethodMetadata
 * @see AnnotationMetadata#getAnnotatedMethods
 * @see AnnotatedTypeMetadata
 * @since 3.0
 */
public interface MethodMetadata extends AnnotatedTypeMetadata {

	/**
	 * 获取方法名
	 * <p>
	 * Get the name of the underlying method.
	 */
	String getMethodName();

	/**
	 * 获取方法所属类的全限定类名
	 * <p>
	 * Get the fully-qualified name of the class that declares the underlying method.
	 */
	String getDeclaringClassName();

	/**
	 * 获取方法返回类型的权限定类名
	 * <p>
	 * Get the fully-qualified name of the underlying method's declared return type.
	 *
	 * @since 4.2
	 */
	String getReturnTypeName();

	/**
	 * 是否抽象方法
	 * <p>
	 * Determine whether the underlying method is effectively abstract:
	 * i.e. marked as abstract in a class or declared as a regular,
	 * non-default method in an interface.
	 *
	 * @since 4.2
	 */
	boolean isAbstract();

	/**
	 * 是否静态方法
	 * <p>
	 * Determine whether the underlying method is declared as 'static'.
	 */
	boolean isStatic();

	/**
	 * 是否final方法
	 * <p>
	 * Determine whether the underlying method is marked as 'final'.
	 */
	boolean isFinal();

	/**
	 * 是否可以重写，即非static、final、private
	 * <p>
	 * Determine whether the underlying method is overridable,
	 * i.e. not marked as static, final, or private.
	 */
	boolean isOverridable();

}
