import os


def get_filepaths(directory):
    """
    This function will generate the file names in a directory
    tree by walking the tree either top-down or bottom-up. For each
    directory in the tree rooted at directory top (including top itself),
    it yields a 3-tuple (dirpath, dirnames, filenames).
    """
    file_paths = []  # List which will store all of the full filepaths.

    # Walk the tree.
    for root, directories, files in os.walk(directory):
        for filename in files:
            # Join the two strings in order to form the full filepath.
            filepath = os.path.join(root, filename)
            file_paths.append(filepath)  # Add it to the list.

    return file_paths  # Self-explanatory.

result = get_filepaths("src")

for r in result:
    if '.java' in r:
        cmd = 'git log --format=format:%an, ' + r + ' |sort |uniq'
        output = os.popen(cmd).read().replace('\n', ' ').rstrip(' ').rstrip(',')
        output = '@author ' + output
        with open(r, 'r+') as f:
            lines = f.readlines()
            for idx in range(0, len(lines)):
                if '@author' in lines[idx]:
                    lines[idx] = lines[idx].split('@')[0] + output + lines[idx][-1]
            f.seek(0)
            f.truncate()
            f.writelines(lines)
