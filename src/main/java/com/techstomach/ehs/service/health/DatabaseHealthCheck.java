/*
 * Copyright (c) 2017 Techstomach (TM)
 *
 * This software is an intellectual property of Techstomach Solutions Pvt Ltd,India.
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.techstomach.ehs.service.health;

import com.codahale.metrics.health.HealthCheck;
import org.skife.jdbi.v2.DBI;
import org.skife.jdbi.v2.Handle;

public class DatabaseHealthCheck extends HealthCheck {

    private final DBI dbi;
    private final String validationQuery;

    public DatabaseHealthCheck(DBI dbi, String validationQuery) {
        this.dbi = dbi;
        this.validationQuery = validationQuery;
    }

    @Override
    protected Result check() {

        try {
            final Handle handle = dbi.open();

            handle.execute(validationQuery);

            handle.close();
        } catch (Exception e) {
            return Result.unhealthy("JDEHS Database is not running!");
        }

        return Result.healthy();
    }
}

