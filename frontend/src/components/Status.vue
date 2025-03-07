<template>
    <div>
        <v-card-title>
            Status
        </v-card-title>
        <v-card-text>
            <div v-if="editMode">
                <v-select
                        v-model="newValue"
                        :label="'name'"
                        :items="statusList"
                ></v-select>
            </div>
            <div v-else>
                Status : {{ value }}
            </div>
        </v-card-text>
    </div>
</template>

<script>
    export default {
        name: 'Status',
        components:{},
        props: {
            value: [Object, String, Number, Boolean, Array],
            editMode: Boolean,
            isNew: Boolean,
            offline: Boolean,
            inList: Boolean,
            label: String,
        },
        data: () => ({
            statusList : [ "CREATED",  "APPROVED",  "CANCELLED",  "REJECTED",  "RESOLVED", ],
            newValue: '',
        }),
        async created() {
            if(!this.value) {
                this.newValue = this.statusList[0];
            } else {
                this.newValue = this.value;
            }
        },
        watch: {
            value(val) {
                this.$emit('input', val);
            },
            newValue(val) {
                this.$emit('input', val);
            },
        },
        methods: {
        }
    }
</script>

