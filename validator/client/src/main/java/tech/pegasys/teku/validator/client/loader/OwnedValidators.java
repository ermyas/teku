/*
 * Copyright 2021 ConsenSys AG.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 */

package tech.pegasys.teku.validator.client.loader;

import static java.util.Collections.unmodifiableSet;

import java.util.Map;
import java.util.Optional;
import java.util.Set;
import tech.pegasys.teku.bls.BLSPublicKey;
import tech.pegasys.teku.validator.client.Validator;

public class OwnedValidators {
  private final Map<BLSPublicKey, Validator> validators;

  public OwnedValidators(final Map<BLSPublicKey, Validator> validators) {
    this.validators = validators;
  }

  public Set<BLSPublicKey> getPublicKeys() {
    return unmodifiableSet(validators.keySet());
  }

  public boolean hasNoValidators() {
    return validators.isEmpty();
  }

  public int getValidatorCount() {
    return validators.size();
  }

  public Optional<Validator> getValidator(final BLSPublicKey publicKey) {
    return Optional.ofNullable(validators.get(publicKey));
  }
}