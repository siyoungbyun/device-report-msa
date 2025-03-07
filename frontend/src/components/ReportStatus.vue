<template>
    <div>
        <v-card-title>
            ReportStatus
        </v-card-title>
        <v-card-text>
            <div v-if="editMode">
                <v-select
                        v-model="newValue"
                        :label="'name'"
                        :items="reportStatusList"
                ></v-select>
            </div>
            <div v-else>
                ReportStatus : {{ value }}
            </div>
        </v-card-text>
    </div>
</template>

<script>
    export default {
        name: 'ReportStatus',
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
            reportStatusList : [ "CREATED",  "APPROVED",  "CANCELLED",  "REJECTED",  "RESOLVED", ],
            newValue: '',
        }),
        async created() {
            if(!this.value) {
                this.newValue = this.reportStatusList[0];
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

