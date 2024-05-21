def load_data_zeros_ones(datasets_dir):
    import os
    import numpy as np
    import torchvision.datasets.mnist as mnist

    datasets_dir = '../datasets'
    if not os.path.exists(datasets_dir):
        os.makedirs(datasets_dir)
    import moxing as mox
    if not os.path.exists(os.path.join(datasets_dir, 'MNIST_data.zip')):
        mox.file.copy('obs://modelarts-labs-bj4/course/hwc_edu/deep_learning/datasets/MNIST_data.zip', 
                      os.path.join(datasets_dir, 'MNIST_data.zip'))
        os.system('cd %s; unzip MNIST_data.zip' % (datasets_dir))
    
    # 读取完整训练样本
    train_data = mnist.read_image_file(os.path.join(datasets_dir, 'MNIST_data/raw/train-images-idx3-ubyte')).numpy().astype(np.uint8)
    train_label = mnist.read_label_file(os.path.join(datasets_dir, 'MNIST_data/raw/train-labels-idx1-ubyte')).numpy().astype(np.uint8)
    # 读取完整测试样本
    test_data = mnist.read_image_file(os.path.join(datasets_dir, 'MNIST_data/raw/t10k-images-idx3-ubyte')).numpy().astype(np.uint8)
    test_label = mnist.read_label_file(os.path.join(datasets_dir, 'MNIST_data/raw/t10k-labels-idx1-ubyte')).numpy().astype(np.uint8)

    train_zeros = train_data[train_label == 0]
    train_ones = train_data[train_label == 1]
    test_zeros = test_data[test_label == 0]
    test_ones = test_data[test_label == 1]

    print('数字0，训练集规模：', len(train_zeros), '，测试集规模：', len(test_zeros))
    print('数字1，训练集规模：', len(train_ones), '，测试集规模：', len(test_ones))
    
    train_x = np.vstack((train_zeros, train_ones))  # 将数字0和1的样本汇总起来，np.vstack表示将两个数组进行垂直拼接
    train_y = np.array([0] * len(train_zeros) + [1] * len(train_ones)).astype(np.uint8)

    test_x = np.vstack((test_zeros, test_ones))  # 将数字0和1的样本汇总起来，np.vstack表示将两个数组进行垂直拼接
    test_y = np.array([0] * len(test_zeros) + [1] * len(test_ones)).astype(np.uint8)
    
    train_x = train_x.reshape(-1, 28*28)  # 每个样本变成一个行向量，因为行向量便于计算
    train_y = train_y.reshape(-1, 1)

    test_x = test_x.reshape(-1, 28*28)  # 每个样本变成一个行向量，因为行向量便于计算
    test_y = test_y.reshape(-1, 1)
    
    train_data = np.hstack((train_x, train_y))  # np.hstack表示将两个数组进行水平拼接
    test_data = np.hstack((test_x, test_y))  # np.hstack表示将两个数组进行水平拼接
    np.random.seed(0)
    np.random.shuffle(train_data)  # 打乱train_data数组的行顺序
    np.random.shuffle(test_data)  # 打乱train_data数组的行顺序
    train_x = train_data[:, :-1]  # 重新取出train_x和train_y
    train_y = train_data[:, -1].reshape(-1, 1)
    test_x = test_data[:, :-1]  # 重新取出train_x和train_y
    test_y = test_data[:, -1].reshape(-1, 1)
    
    train_x = train_x.astype(np.float) / 255.0
    train_y = train_y.astype(np.float)

    test_x = test_x.astype(np.float) / 255.0
    test_y = test_y.astype(np.float)

    return train_x, train_y, test_x, test_y