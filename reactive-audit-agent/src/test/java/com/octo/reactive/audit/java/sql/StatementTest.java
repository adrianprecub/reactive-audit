/*
 * Copyright 2014 OCTO Technology
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.octo.reactive.audit.java.sql;

import com.octo.reactive.audit.ReactiveAudit;
import com.octo.reactive.audit.TestTools;
import com.octo.reactive.audit.lib.NetworkReactiveAuditException;
import org.junit.Test;

import java.sql.SQLException;
import java.sql.Statement;

public class StatementTest
{
	private final Statement statement = (Statement) TestTools.createProxy(Statement.class);

	@Test(expected = NetworkReactiveAuditException.class)
	public void execute()
			throws InterruptedException, ClassNotFoundException, SQLException
	{
		ReactiveAudit.strict.commit();
		statement.execute(null);
	}

	@Test(expected = NetworkReactiveAuditException.class)
	public void getMoreResults()
			throws InterruptedException, ClassNotFoundException, SQLException
	{
		ReactiveAudit.strict.commit();
		statement.getMoreResults();
	}

	@Test(expected = NetworkReactiveAuditException.class)
	public void getResultSet()
			throws InterruptedException, ClassNotFoundException, SQLException
	{
		ReactiveAudit.strict.commit();
		statement.getResultSet();
	}

}