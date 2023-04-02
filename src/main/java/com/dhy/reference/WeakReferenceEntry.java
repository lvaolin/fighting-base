package com.dhy.reference;

import java.lang.ref.WeakReference;

public class WeakReferenceEntry extends WeakReference<ThreadLocal<?>> {
            /** The value associated with this ThreadLocal. */
            Object value;

            WeakReferenceEntry(ThreadLocal<?> k, Object v) {
                super(k);
                value = v;
            }
        }
