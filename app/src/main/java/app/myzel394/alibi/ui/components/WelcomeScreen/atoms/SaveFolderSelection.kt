package app.myzel394.alibi.ui.components.WelcomeScreen.atoms

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.widthIn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Folder
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.PermMedia
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.unit.dp
import app.myzel394.alibi.R
import app.myzel394.alibi.ui.RECORDER_MEDIA_SELECTED_VALUE
import app.myzel394.alibi.ui.components.atoms.MessageBox
import app.myzel394.alibi.ui.components.atoms.MessageType
import app.myzel394.alibi.ui.components.atoms.VisualDensity

const val CUSTOM_FOLDER = "custom"

@Composable
fun SaveFolderSelection(
    modifier: Modifier = Modifier,
    saveFolder: String?,
    isLowOnStorage: Boolean,
    onSaveFolderChange: (String?) -> Unit,
) {
    @Composable
    fun createModifier(a11yLabel: String, onClick: () -> Unit) =
        Modifier
            .fillMaxWidth()
            .clip(MaterialTheme.shapes.medium)
            .semantics {
                contentDescription = a11yLabel
            }
            .clickable(onClick = onClick)
            .padding(16.dp)
            .padding(end = 8.dp)

    Column(
        verticalArrangement = Arrangement.spacedBy(16.dp),
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .clip(MaterialTheme.shapes.medium)
                .background(MaterialTheme.colorScheme.surfaceContainer)
                .then(modifier),
            verticalArrangement = Arrangement.Center,
        ) {
            let {
                val label = stringResource(R.string.ui_welcome_saveFolder_values_internal)
                val a11yLabel = stringResource(
                    R.string.a11y_selectValue,
                    label
                )
                val folder = null

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = createModifier(a11yLabel) {
                        onSaveFolderChange(folder)
                    },
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(8.dp),
                    ) {
                        RadioButton(
                            selected = saveFolder == folder,
                            onClick = { onSaveFolderChange(folder) },
                        )
                        Text(label)
                    }
                    Icon(
                        Icons.Default.Lock,
                        contentDescription = null,
                        modifier = Modifier
                            .size(ButtonDefaults.IconSize)
                    )
                }
            }
            let {
                val label = stringResource(R.string.ui_welcome_saveFolder_values_media)
                val a11yLabel = stringResource(
                    R.string.a11y_selectValue,
                    label
                )
                val folder = RECORDER_MEDIA_SELECTED_VALUE

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = createModifier(a11yLabel) {
                        onSaveFolderChange(folder)
                    },
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(8.dp),
                    ) {
                        RadioButton(
                            selected = saveFolder == folder,
                            onClick = { onSaveFolderChange(folder) },
                        )
                        Text(label)
                    }
                    Icon(
                        Icons.Default.PermMedia,
                        contentDescription = null,
                        modifier = Modifier
                            .size(ButtonDefaults.IconSize)
                    )
                }
            }
            let {
                val label = stringResource(R.string.ui_welcome_saveFolder_values_custom)
                val a11yLabel = stringResource(
                    R.string.a11y_selectValue,
                    label
                )
                val folder = CUSTOM_FOLDER

                Column(
                    horizontalAlignment = Alignment.Start,
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween,
                        modifier = createModifier(a11yLabel) {
                            onSaveFolderChange(folder)
                        },
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(8.dp),
                        ) {
                            RadioButton(
                                selected = saveFolder == folder,
                                onClick = { onSaveFolderChange(folder) },
                            )
                            Text(label)
                        }
                        Icon(
                            Icons.Default.Folder,
                            contentDescription = null,
                            modifier = Modifier
                                .size(ButtonDefaults.IconSize)
                        )
                    }
                }
            }
        }
        if (isLowOnStorage && saveFolder == null)
            MessageBox(
                type = MessageType.ERROR,
                message = stringResource(R.string.ui_welcome_saveFolder_externalRequired)
            )
        else
            Box(
                modifier = Modifier.widthIn(max = 400.dp)
            ) {
                MessageBox(
                    type = MessageType.INFO,
                    message = stringResource(R.string.ui_welcome_timeSettings_changeableHint),
                    density = VisualDensity.DENSE,
                )
            }
    }
}